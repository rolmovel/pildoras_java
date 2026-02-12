import java.util.HashMap;
import java.util.Map;

public class SafeCart {
    private final InventoryService inventoryService;
    private final ErrorReporter errorReporter;
    private final Map<String, Integer> items = new HashMap<>();

    public SafeCart(InventoryService inventoryService, ErrorReporter errorReporter) {
        this.inventoryService = inventoryService;
        this.errorReporter = errorReporter;
    }

    public void addItem(String sku, int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Cantidad inválida: " + quantity);
        }
        if (!inventoryService.hasStock(sku, quantity)) {
            throw new OutOfStockException("No hay stock suficiente para " + sku);
        }
        items.merge(sku, quantity, Integer::sum);
    }

    public void checkout() {
        try {
            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                inventoryService.reserve(entry.getKey(), entry.getValue());
            }
            items.clear();
        } catch (RuntimeException ex) {
            errorReporter.log("Error en checkout: " + ex.getMessage());
            throw ex;
        }
    }
}
