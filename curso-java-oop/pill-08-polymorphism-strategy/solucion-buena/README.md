# Solución: Estrategias polimórficas

## Diagrama de clases

```mermaid
classDiagram
  class CostStrategy {
    <<interface>>
    +apply(double) double
  }

  class NoTaxStrategy {
    +apply(double) double
  }

  class FlatTaxStrategy {
    -double percentage
    +apply(double) double
  }

  class StandardShipping {
    -double base
    +apply(double) double
  }

  class ExpressShipping {
    -double surcharge
    +apply(double) double
  }

  class CheckoutCalculator {
    -List<CostStrategy> strategies
    +addStrategy(CostStrategy) void
    +calculate(double) double
  }

  CostStrategy <|.. NoTaxStrategy
  CostStrategy <|.. FlatTaxStrategy
  CostStrategy <|.. StandardShipping
  CostStrategy <|.. ExpressShipping
  CheckoutCalculator *--> CostStrategy
```

## Principios aplicados

1. **Patrón Strategy**: cada estrategia encapsula su regla y `CheckoutCalculator` las combina dinámicamente.
2. **Polimorfismo**: nuevas reglas se integran a través de la interfaz sin condicionales adicionales.
3. **Composición**: el calculador mantiene una lista de estrategias aplicadas en secuencia.

## Beneficios

- ✅ Fácil extender con impuestos o envíos adicionales.
- ✅ Reglas testeables de forma aislada.
- ✅ Reutilización: la misma estrategia puede aplicarse en distintos contextos.
