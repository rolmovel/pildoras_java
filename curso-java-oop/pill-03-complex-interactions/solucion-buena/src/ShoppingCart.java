import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();
    
    public void addProduct(Product product, int quantity) {
        items.merge(product, quantity, Integer::sum);
    }
    
    public double calculateTotal() {
        return items.entrySet().stream()
                   .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
                   .sum();
    }
    
    public Map<Product, Integer> getItems() { 
        return new HashMap<>(items); 
    }
}
