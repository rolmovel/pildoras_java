# Análisis de solución alternativa

## Problemas detectados

1. **Violación de encapsulación**:
   - Atributos públicos permiten modificaciones inválidas:
     ```java
     car.speed = -100; // Permitido pero inválido
     ```

2. **Falta de validación**:
   - No hay control sobre valores negativos de velocidad

3. **Código duplicado**:
   - La lógica de validación debe repetirse en cada uso:
     ```java
     // En lugar de:
     car.brake(20);
     
     // Debemos hacer:
     if (car.speed >= 20) {
         car.speed -= 20;
     } else {
         car.speed = 0;
     }
     ```

## Beneficios de la solución buena

✅ **Encapsulación**  
   - Estado protegido contra modificaciones inválidas  

✅ **Centralización de lógica**  
   - Validaciones en un único punto de modificación  

✅ **Mantenibilidad**  
   - Cambios en reglas de negocio afectan solo la clase  

✅ **Extensibilidad**  
   - Fácil añadir nuevas funcionalidades
