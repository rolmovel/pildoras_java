import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public void addStock(String sku, int quantity) {
        stock.merge(sku, quantity, Integer::sum);
    }

    public boolean hasStock(String sku, int quantity) {
        return stock.getOrDefault(sku, 0) >= quantity;
    }

    public void reserve(String sku, int quantity) {
        if (!hasStock(sku, quantity)) {
            throw new OutOfStockException("Sin stock para " + sku);
        }
        stock.put(sku, stock.get(sku) - quantity);
    }
}
