# Solución: Interacciones complejas

## Diagrama de Clases
```mermaid
classDiagram
  class Product {
    -String sku
    -String name
    -double price
  }

  class ShoppingCart {
    -Map<Product, Integer> items
    +addProduct(Product, int) void
    +calculateTotal() double
  }

  class ECommerceSystem {
    -Map<Product, Integer> inventory
    +processOrder(ShoppingCart) void
  }

  ShoppingCart "1" o-- "*" Product
  ECommerceSystem --> ShoppingCart
```

## Principios OOP aplicados

1. **Agregación**  
   - `ShoppingCart` contiene productos sin poseer su ciclo de vida  

2. **Encapsulación**  
   - Estado interno protegido en todas las clases  

3. **Responsabilidad única**  
   - Cada clase gestiona solo su propia lógica  

## Beneficios clave

✅ **Flexibilidad** para modificar componentes individuales  

✅ **Escalabilidad** mediante nuevas funcionalidades  

✅ **Mantenibilidad** con dependencias claras
