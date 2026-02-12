# Ejercicio: Cuentas bancarias seguras

## Requisitos

- Diseñar una clase `BankAccount` que proteja todo su estado interno.
- La cuenta debe exponer únicamente operaciones válidas:
  - `deposit(double amount)` con validación de montos positivos.
  - `withdraw(double amount)` respetando saldo disponible y un límite diario configurable.
  - `freeze()`/`unfreeze()` para bloquear operaciones sospechosas.
- Registrar cada operación en un historial inmutable de auditoría.
- Evitar que código externo pueda modificar directamente saldo, límites o banderas internas.
- Preparar una pequeña capa de logging/auditoría reutilizable.
