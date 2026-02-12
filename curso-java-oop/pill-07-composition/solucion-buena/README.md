# Solución: Composición y agregación

## Diagrama de clases

```mermaid
classDiagram
  class Product {
    -String sku
    -String name
    -double price
  }

  class Customer {
    -String name
    -String email
  }

  class Address {
    -String street
    -String city
    -String country
  }

  class OrderItem {
    -Product product
    -int quantity
    +subtotal() double
  }

  class Order {
    -Customer customer
    -Address shippingAddress
    -List<OrderItem> items
    -List<Charge> extraCharges
    +addItem(Product, int) void
    +addCharge(Charge) void
    +total() double
  }

  class Charge {
    <<interface>>
    +apply(double) double
  }

  Product <.. OrderItem
  OrderItem "*" --> "1" Product
  Order "1" o-- "*" OrderItem
  Order --> Customer
  Order --> Address
  Order --> Charge
```

## Principios aplicados

1. **Composición clara**: `Order` contiene `OrderItem` y la dirección; la vida útil depende del pedido.
2. **Agregación controlada**: `Product` y `Customer` pueden existir sin el pedido, pero se referencian para reutilizar datos.
3. **Extensibilidad vía objetos colaborativos**: `Charge` permite modelar descuentos/envíos sin modificar `Order`.

## Beneficios

- ✅ Se evita duplicar atributos de productos dentro del pedido.
- ✅ Cambiar la dirección implica reemplazar el objeto sin tocar los ítems.
- ✅ Agregar descuentos o cargos solo requiere nuevas implementaciones de `Charge`.
