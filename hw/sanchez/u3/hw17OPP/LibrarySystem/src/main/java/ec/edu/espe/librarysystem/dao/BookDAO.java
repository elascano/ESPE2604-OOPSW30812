package ec.edu.espe.librarysystem.dao;

import ec.edu.espe.librarysystem.model.Book;
import java.util.List;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public interface BookDAO {

    void save(Book book);

    List<Book> findAll();

    Book findById(String bookId);

    void update(Book book);

    void delete(String bookId);
}