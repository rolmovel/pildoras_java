# Ejercicio: Pedidos con composición

## Requisitos

- Modelar un pedido (`Order`) que se compone de múltiples `OrderItem`.
- `OrderItem` debe conocer al `Product` que representa y su cantidad.
- `Order` necesita asociar un `Customer` y una `Address` de entrega.
- Calcular el total del pedido sumando subtotales de cada ítem.
- Permitir aplicar descuentos y costos de envío como objetos colaborativos.
- Garantizar que los cambios en `Address` o `Customer` no rompan el pedido (composición/agrupación clara).
