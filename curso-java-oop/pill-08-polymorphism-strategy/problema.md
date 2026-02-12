# Ejercicio: Estrategias de cálculo de envío y tax

## Requisitos

- Crear un sistema de cálculo de costos donde los impuestos y envíos se elijan dinámicamente.
- Debe existir una interfaz `CostStrategy` con método `double apply(double baseAmount)`.
- Estrategias deseadas:
  - `NoTaxStrategy`: no modifica el monto.
  - `FlatTaxStrategy`: aplica un porcentaje fijo.
  - `ShippingStrategy`: distintos costos según región (`StandardShipping`, `ExpressShipping`).
- Una clase `CheckoutCalculator` recibirá listas de estrategias para componer el costo final.
- Debe ser fácil añadir nuevas estrategias sin tocar el cálculo central.
- Comparar con una solución monolítica que usa condicionales en cascada.
