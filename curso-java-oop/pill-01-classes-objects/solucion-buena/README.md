# Solución Orientada a Objetos

## Diagrama de Clases
```mermaid
classDiagram
  class Car {
    -String brand
    -int speed
    +Car(String brand)
    +accelerate(int amount) void
    +brake(int amount) void
    +getBrand() String
    +getSpeed() int
  }
```

## Flujo de ejecución
```mermaid
sequenceDiagram
  actor Usuario
  participant Main
  participant Car

  Usuario->>Main: Crear auto
  Main->>Car: new Car("Toyota")
  Main->>Usuario: Auto creado

  Usuario->>Main: Acelerar 50 km/h
  Main->>Car: accelerate(50)
  Car-->>Main: OK

  Usuario->>Main: Frenar 20 km/h
  Main->>Car: brake(20)
  Car-->>Main: OK

  Usuario->>Main: Consultar velocidad
  Main->>Car: getSpeed()
  Car-->>Main: 30
  Main-->>Usuario: Velocidad: 30 km/h
```

## Principios OOP aplicados

1. **Encapsulación**  
   - Atributos privados (`brand`, `speed`)  
   - Métodos públicos para interacción (`accelerate`, `brake`)  

2. **Abstracción**  
   - Ocultación de implementación (validaciones internas)  

3. **Cohesión**  
   - La clase tiene responsabilidad única: gestionar estado del vehículo  

## Beneficios clave

✅ **Seguridad de datos**  
   - Imposible asignar velocidad negativa  

✅ **Código autocontenido**  
   - Todas las operaciones relacionadas en un mismo lugar  

✅ **Facilidad de uso**  
   - Interfaz simple (`accelerate`, `brake`) oculta complejidad
