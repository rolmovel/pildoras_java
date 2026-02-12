# Solución: Contratos de pago con interfaces

## Diagrama de clases

```mermaid
classDiagram
  interface PaymentMethod {
    +pay(double) void
  }

  class CreditCardPayment {
    -String cardNumber
    -String holder
    +pay(double) void
  }

  class PaypalPayment {
    -String accountEmail
    +pay(double) void
  }

  class PaymentProcessor {
    +process(double, PaymentMethod) void
  }

  PaymentMethod <|.. CreditCardPayment
  PaymentMethod <|.. PaypalPayment
  PaymentProcessor --> PaymentMethod
```

## Principios aplicados

1. **Programar contra interfaces**: `PaymentProcessor` depende de `PaymentMethod`, no de implementaciones concretas.
2. **Abierto/cerrado**: nuevas formas de pago solo requieren añadir clases que implementen la interfaz.
3. **Responsabilidad única**: cada método se encarga de validar y ejecutar su cobro específico.

## Beneficios

- ✅ Extensibilidad sin tocar el procesador.
- ✅ Validaciones localizadas por método, evitando condicionales globales.
- ✅ Facilita pruebas con dobles o implementaciones simuladas.
