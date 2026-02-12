import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books = new ArrayList<>();
    
    public void addBook(Book book) {
        books.add(book);
    }
    
    public List<Book> findBooksByAuthor(String authorName) {
        return books.stream()
                   .filter(b -> b.getAuthor().getName().equals(authorName))
                   .collect(Collectors.toList());
    }
    
    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                   .filter(b -> b.getTitle().contains(title))
                   .collect(Collectors.toList());
    }
    
    public void borrowBook(Book book) {
        if (!book.isBorrowed()) {
            book.borrow();
        }
    }
    
    public void returnBook(Book book) {
        if (book.isBorrowed()) {
            book.returnBook();
        }
    }
}
