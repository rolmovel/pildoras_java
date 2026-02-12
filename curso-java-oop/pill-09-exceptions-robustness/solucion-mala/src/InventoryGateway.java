import java.util.HashMap;
import java.util.Map;

public class InventoryGateway {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryGateway() {
        stock.put("ABC", 1);
        stock.put("XYZ", 0);
    }

    public int getStock(String sku) {
        return stock.getOrDefault(sku, 0);
    }

    public void remove(String sku, int quantity) {
        stock.put(sku, Math.max(0, getStock(sku) - quantity));
    }
}
