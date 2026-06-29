package ec.edu.espe.librarysystem.controller;

import ec.edu.espe.librarysystem.dao.BookDAO;
import ec.edu.espe.librarysystem.model.Book;
import java.util.List;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class BookController {

    private final BookDAO dao;

    public BookController(BookDAO dao) {
        this.dao = dao;
    }

    public void saveBook(Book book) {
        dao.save(book);
    }

    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    public Book getBookById(String id) {
        return dao.findById(id);
    }

    public void updateBook(Book book) {
        dao.update(book);
    }

    public void deleteBook(String id) {
        dao.delete(id);
    }
}
