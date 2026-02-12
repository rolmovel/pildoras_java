# Solución: Interacciones entre objetos

## Diagrama de Clases
```mermaid
classDiagram
  class Author {
    -String name
    -String country
    +getName() String
  }

  class Book {
    -String title
    -Author author
    -int year
    -boolean borrowed
    +borrow() void
    +returnBook() void
  }

  class Library {
    -List<Book> books
    +addBook(Book) void
    +findBooksByAuthor(String) List<Book>
  }

  Book "1" *-- "1" Author
  Library "1" *-- "*" Book
```

## Principios OOP aplicados

1. **Composición**  
   - `Book` contiene un objeto `Author`  

2. **Colaboración**  
   - `Library` gestiona una colección de `Book`  

3. **Encapsulación**  
   - Estado interno protegido en todas las clases  

## Beneficios clave

✅ **Relaciones claras** entre entidades  

✅ **Reutilización de objetos** (mismo autor en múltiples libros)  

✅ **Código mantenible** con responsabilidades bien definidas
