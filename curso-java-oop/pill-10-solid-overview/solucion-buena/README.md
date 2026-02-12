# Solución: Aplicación práctica de SOLID

## Diagrama de clases

```mermaid
classDiagram
  class SolidOrder {
    +double amount
    +String customerEmail
  }

  class DiscountPolicy {
    <<interface>>
    +double apply(double)
  }

  class PercentageDiscount {
    -double percentage
    +apply(double) double
  }

  class FixedDiscount {
    -double value
    +apply(double) double
  }

  class PaymentGateway {
    <<interface>>
    +charge(double) void
  }

  class StripeGateway {
    +charge(double) void
  }

  class Notifier {
    <<interface>>
    +notify(String, String) void
  }

  class EmailNotifier {
    +notify(String, String) void
  }

  class OrderProcessor {
    -DiscountPolicy discountPolicy
    -PaymentGateway paymentGateway
    -Notifier notifier
    +process(Order) void
  }

  DiscountPolicy <|.. PercentageDiscount
  DiscountPolicy <|.. FixedDiscount
  PaymentGateway <|.. StripeGateway
  Notifier <|.. EmailNotifier
  OrderProcessor --> DiscountPolicy
  OrderProcessor --> PaymentGateway
  OrderProcessor --> Notifier
  OrderProcessor --> SolidOrder
```

## Principios SOLID aplicados

1. **SRP** (Responsabilidad única): `OrderProcessor` coordina el flujo, mientras descuentos, pagos y notificaciones se delegan a sus propias clases.
2. **OCP** (Abierto/Cerrado): nuevas políticas de descuento se añaden implementando `DiscountPolicy` sin tocar `OrderProcessor`.
3. **LSP**: cualquier `DiscountPolicy` o `PaymentGateway` puede sustituirse sin romper el contrato.
4. **ISP**: cada interfaz define solo los métodos necesarios (`charge`, `apply`, `notify`).
5. **DIP**: el procesador depende de abstracciones; recibe sus colaboraciones por constructor.

## Beneficios

- ✅ Escalabilidad: agregar gateways o políticas no implica modificar la clase central.
- ✅ Testabilidad: se pueden usar dobles de prueba al inyectar dependencias.
- ✅ Legibilidad: cada clase se enfoca en una tarea y evita condicionales en cascada.
