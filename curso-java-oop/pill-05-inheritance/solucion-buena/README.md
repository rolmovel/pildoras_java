# Solución: Herencia bien diseñada

## Diagrama de clases

```mermaid
classDiagram
  class Vehicle {
    <<abstract>>
    -String vin
    -double fuelCapacity
    -double consumptionPer100km
    +Vehicle(String, double, double)
    +start() void
    +stop() void
    +calculateRange() double
  }

  class Car {
    -int doors
    +Car(String, double, double, int)
    +start() void
  }

  class Truck {
    -double maxLoad
    +Truck(String, double, double, double)
    +calculateToll() double
  }

  class FleetManager {
    +register(Vehicle) void
    +printStatus() void
  }

  Vehicle <|-- Car
  Vehicle <|-- Truck
  FleetManager o--> Vehicle
```

## Principios aplicados

1. **Herencia con propósito**: `Vehicle` encapsula comportamiento común y obliga a subclases a especializar solo lo necesario.
2. **Polimorfismo**: `FleetManager` opera sobre la abstracción `Vehicle` para recorrer flotas mixtas sin condicionales.
3. **Responsabilidad única**: cada clase mantiene una función clara (vehículo genérico, auto, camión, gestor).

## Beneficios

- ✅ Reutilización de código para cálculo de autonomía, arranque y detención.
- ✅ Facilidad para añadir nuevas subclases (`Motorcycle`, `Bus`) sin modificar `FleetManager`.
- ✅ Lógica de negocio coherente: cada método conoce solo los datos que le pertenecen.
