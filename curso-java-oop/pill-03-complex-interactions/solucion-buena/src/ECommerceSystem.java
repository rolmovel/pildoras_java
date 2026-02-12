import java.util.HashMap;
import java.util.Map;

public class ECommerceSystem {
    private final Map<Product, Integer> inventory = new HashMap<>();
    
    public void addToInventory(Product product, int quantity) {
        inventory.put(product, quantity);
    }
    
    public void processOrder(ShoppingCart cart) {
        cart.getItems().forEach((product, quantity) -> {
            int currentStock = inventory.getOrDefault(product, 0);
            if (currentStock < quantity) {
                throw new RuntimeException("Stock insuficiente para: " + product.getName());
            }
            inventory.put(product, currentStock - quantity);
        });
    }
}
