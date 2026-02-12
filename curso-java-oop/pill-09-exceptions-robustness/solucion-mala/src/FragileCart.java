import java.util.HashMap;
import java.util.Map;

public class FragileCart {
    public final Map<String, Integer> items = new HashMap<>();
    public final InventoryGateway inventoryGateway;
    public String lastError;

    public FragileCart(InventoryGateway inventoryGateway) {
        this.inventoryGateway = inventoryGateway;
    }

    public boolean addItem(String sku, int quantity) {
        if (quantity <= 0) {
            lastError = "Cantidad inválida";
            return false;
        }
        int stock = inventoryGateway.getStock(sku);
        if (stock < quantity) {
            lastError = "Sin stock";
            return false;
        }
        items.merge(sku, quantity, Integer::sum);
        return true;
    }

    public boolean checkout() {
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            int stock = inventoryGateway.getStock(entry.getKey());
            if (stock < entry.getValue()) {
                lastError = "Sin stock en checkout";
                return false;
            }
            inventoryGateway.remove(entry.getKey(), entry.getValue());
        }
        items.clear();
        return true;
    }
}
