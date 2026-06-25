package ec.edu.espe.librarysystem.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.librarysystem.model.Book;
import ec.edu.espe.librarysystem.utils.MongoConnection;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class MongoBookDAO implements BookDAO {

    private final MongoCollection<Document> collection;

    public MongoBookDAO() {
        MongoDatabase database =
                MongoConnection.getDatabase();

        collection =
                database.getCollection("books");
    }

    @Override
    public void save(Book book) {

        Document document = new Document()
                .append("bookId", book.getBookId())
                .append("title", book.getTitle())
                .append("author", book.getAuthor());

        collection.insertOne(document);
    }

    @Override
    public List<Book> findAll() {

        List<Book> books = new ArrayList<>();

        for (Document d : collection.find()) {

            Book book = new Book(
                    d.getString("bookId"),
                    d.getString("title"),
                    d.getString("author"));

            books.add(book);
        }

        return books;
    }

    @Override
    public Book findById(String bookId) {

        Document d = collection
                .find(Filters.eq("bookId", bookId))
                .first();

        if (d == null) {
            return null;
        }

        return new Book(
                d.getString("bookId"),
                d.getString("title"),
                d.getString("author"));
    }

    @Override
    public void update(Book book) {

        Document document = new Document()
                .append("bookId", book.getBookId())
                .append("title", book.getTitle())
                .append("author", book.getAuthor());

        collection.replaceOne(
                Filters.eq("bookId", book.getBookId()),
                document);
    }

    @Override
    public void delete(String bookId) {

        collection.deleteOne(
                Filters.eq("bookId", bookId));
    }
}