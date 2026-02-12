# Ejercicio: Aplicar principios SOLID en un módulo de pedidos

## Requisitos

- Crear un servicio `OrderProcessor` que reciba pedidos, calcule descuentos y procese pagos.
- Debe apoyarse en colaboraciones:
  - `DiscountPolicy` (OCP) para variar reglas sin modificar el procesador.
  - `PaymentGateway` (DIP) para no acoplarse a implementaciones concretas.
  - `Notifier` (SRP) para enviar confirmaciones.
- El servicio debe ser fácil de extender con nuevas políticas y gateways.
- Comparar con una implementación monolítica que viola los principios SOLID.
