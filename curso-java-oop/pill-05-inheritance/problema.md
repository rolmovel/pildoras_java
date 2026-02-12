# Ejercicio: Jerarquía de vehículos

## Requisitos

- Diseñar una jerarquía con `Vehicle` como clase base.
- Especializaciones:
  - `Car`: número de puertas, consumo estándar.
  - `Truck`: capacidad de carga y cálculo de peaje específico.
- `Vehicle` debe exponer comportamiento genérico (`start`, `stop`, `calculateRange`).
- Añadir una clase `FleetManager` que procese arreglos de vehículos heterogéneos.
- Evitar duplicación de código entre subclases y asegurar que cada una sobrescriba solo lo necesario.
