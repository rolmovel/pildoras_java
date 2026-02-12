# Ejercicio: Procesador de pagos con interfaces

## Requisitos

- Definir un contrato `PaymentMethod` que encapsule la lógica de cobro (`pay(double amount)`).
- Implementaciones iniciales: `CreditCardPayment`, `PaypalPayment`.
- Un `PaymentProcessor` debe recibir cualquier `PaymentMethod` y ejecutar el pago sin conocer detalles concretos.
- Validar montos mínimos y manejar errores específicos de cada método.
- Permitir agregar nuevos métodos de pago sin modificar el procesador.
