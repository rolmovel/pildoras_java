# Solución: Manejo robusto de excepciones

## Diagrama de clases

```mermaid
classDiagram
  class SafeCart {
    -InventoryService inventoryService
    -ErrorReporter errorReporter
    +addItem(String sku, int qty) void
    +checkout() void
  }

  class InventoryService {
    +boolean hasStock(String, int)
    +void reserve(String, int)
  }

  class ErrorReporter {
    +log(String) void
  }

  class OutOfStockException
  class InvalidQuantityException

  SafeCart --> InventoryService
  SafeCart --> ErrorReporter
  SafeCart ..> OutOfStockException
  SafeCart ..> InvalidQuantityException
```

## Principios aplicados

1. **Fail-fast**: se lanzan excepciones específicas al detectar cantidades inválidas o falta de stock.
2. **Separación de responsabilidades**: `InventoryService` valida disponibilidad mientras `SafeCart` coordina operaciones.
3. **Observabilidad**: `ErrorReporter` centraliza el registro de errores críticos para auditoría.

## Beneficios

- ✅ Nunca se devuelven valores ambiguos (`null`, códigos mágicos).
- ✅ Las pruebas pueden esperar excepciones concretas y simular servicios.
- ✅ Historial claro de errores a través del reporter.
