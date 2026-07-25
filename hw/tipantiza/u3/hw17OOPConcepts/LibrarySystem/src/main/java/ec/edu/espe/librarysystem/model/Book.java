
package ec.edu.espe.librarysystem.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class Book {
    private String id;
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean available;
    private String category;

    public Book() {
    }

    public Book(String id, String title, String author, String isbn, 
                int publicationYear, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.available = true;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void borrow() {
        if (!available) {
            throw new IllegalStateException("Book is not available");
        }
        this.available = false;
    }

    public void returnBook() {
        this.available = true;
    }

    @Override
    public String toString() {
        return "Book: " + title + " - " + author + " (" + isbn + ")";
    }
}
