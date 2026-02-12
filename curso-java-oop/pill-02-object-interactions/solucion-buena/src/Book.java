public class Book {
    private final String title;
    private final Author author;
    private final int year;
    private boolean borrowed;
    
    public Book(String title, Author author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }
    
    public void borrow() { borrowed = true; }
    public void returnBook() { borrowed = false; }
    public boolean isBorrowed() { return borrowed; }
    
    public String getTitle() { return title; }
    public Author getAuthor() { return author; }
    public int getYear() { return year; }
}
