# Ejercicio: Manejo robusto de excepciones

## Requisitos

- Implementar un carrito (`SafeCart`) que verifique stock antes de confirmar compras.
- Debe lanzar excepciones específicas: `OutOfStockException`, `InvalidQuantityException`.
- Las operaciones (`addItem`, `checkout`) no pueden devolver `null` ni códigos mágicos.
- Registrar los errores críticos en un `ErrorReporter`.
- Comparar con una solución que silencie errores y devuelva valores por defecto.
