
package ec.edu.espe.librarysystem.controller;
import ec.edu.espe.librarysystem.model.Book;
import ec.edu.espe.librarysystem.model.Loan;
import ec.edu.espe.librarysystem.model.User;
import ec.edu.espe.librarysystem.model.interfaces.IManageable;
import ec.edu.espe.librarysystem.utils.MongoDBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class LibraryController implements IManageable<Book> {
    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;
    private final MongoDBConnection dbConnection;
    private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);

    public LibraryController() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.dbConnection = MongoDBConnection.getInstance();
        loadInitialData();
    }

    @Override
    public void add(Book book) {
        if (book.getId() == null || book.getId().isEmpty()) {
            book.setId(UUID.randomUUID().toString());
        }
        books.add(book);
        dbConnection.insertDocument(MongoDBConnection.BOOKS_COLLECTION, book);
        logger.info("Book added: {}", book.getTitle());
    }

    @Override
    public void remove(String id) {
        books.removeIf(book -> book.getId().equals(id));
        dbConnection.deleteDocument(MongoDBConnection.BOOKS_COLLECTION, id);
        logger.info("Book removed with ID: {}", id);
    }

    @Override
    public Book find(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public void update(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(book.getId())) {
                books.set(i, book);
                dbConnection.updateDocument(MongoDBConnection.BOOKS_COLLECTION, book.getId(), book);
                break;
            }
        }
    }

    public void addUser(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }
        users.add(user);
        dbConnection.insertDocument(MongoDBConnection.USERS_COLLECTION, user);
        logger.info("User added: {}", user.getFullName());
    }

    public User findUser(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(users);
    }

    public void removeUser(String id) {
        users.removeIf(user -> user.getId().equals(id));
        dbConnection.deleteDocument(MongoDBConnection.USERS_COLLECTION, id);
        logger.info("User removed with ID: {}", id);
    }

    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                dbConnection.updateDocument(MongoDBConnection.USERS_COLLECTION, user.getId(), user);
                break;
            }
        }
    }

    public void createLoan(String userId, String bookId) {
        User user = findUser(userId);
        Book book = find(bookId);
        
        validateLoanRequest(user, book);

        Loan loan = new Loan(
            UUID.randomUUID().toString(),
            userId,
            bookId,
            new java.util.Date()
        );
        
        loans.add(loan);
        book.borrow();
        user.addLoan(bookId);
        
        dbConnection.insertDocument(MongoDBConnection.LOANS_COLLECTION, loan);
        update(book);
        updateUser(user);
        
        logger.info("Loan created: User {} - Book {}", user.getFullName(), book.getTitle());
    }

    private void validateLoanRequest(User user, Book book) {
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book '" + book.getTitle() + "' is not available");
        }
        if (!user.canBorrow()) {
            throw new IllegalStateException("User has reached maximum loan limit");
        }
    }

    public void returnLoan(String loanId) {
        Loan loan = loans.stream()
                .filter(l -> l.getId().equals(loanId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        loan.setReturnDate(new java.util.Date());
        loan.setStatus("RETURNED");
        
        Book book = find(loan.getBookId());
        if (book != null) {
            book.returnBook();
            update(book);
        }
        
        User user = findUser(loan.getUserId());
        if (user != null) {
            user.returnLoan(loan.getBookId());
            updateUser(user);
        }
        
        dbConnection.updateDocument(MongoDBConnection.LOANS_COLLECTION, loanId, loan);
        logger.info("Loan returned: {}", loanId);
    }

    public List<Loan> findAllLoans() {
        return new ArrayList<>(loans);
    }

    public List<Loan> findActiveLoans() {
        return loans.stream()
                .filter(loan -> "ACTIVE".equals(loan.getStatus()))
                .toList();
    }

    public List<Loan> findLoansByUser(String userId) {
        return loans.stream()
                .filter(loan -> loan.getUserId().equals(userId))
                .toList();
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getTotalUsers() {
        return users.size();
    }

    public int getActiveLoansCount() {
        return (int) loans.stream()
                .filter(loan -> "ACTIVE".equals(loan.getStatus()))
                .count();
    }

    public int getAvailableBooksCount() {
        return (int) books.stream()
                .filter(Book::isAvailable)
                .count();
    }

    public void displayInformation(Object object) {
        if (object instanceof Book) {
            Book book = (Book) object;
            logger.info("Book: {} by {}", book.getTitle(), book.getAuthor());
        } else if (object instanceof User) {
            User user = (User) object;
            logger.info("User: {} {}", user.getFirstName(), user.getLastName());
        } else if (object instanceof Loan) {
            Loan loan = (Loan) object;
            logger.info("Loan: {} - Status: {}", loan.getId(), loan.getStatus());
        } else {
            logger.warn("Unknown object type: {}", object.getClass().getSimpleName());
        }
    }

    private void loadInitialData() {
        try {
            loadBooksFromDatabase();
            loadUsersFromDatabase();
            loadLoansFromDatabase();
            
            if (books.isEmpty() && users.isEmpty()) {
                createSampleData();
            }
        } catch (Exception e) {
            logger.warn("Error loading initial data", e);
            createSampleData();
        }
    }

    private void loadBooksFromDatabase() {
        List<Book> booksFromDB = dbConnection.findAllDocuments(
            MongoDBConnection.BOOKS_COLLECTION, 
            Book.class
        );
        if (!booksFromDB.isEmpty()) {
            this.books = booksFromDB;
            logger.info("Loaded {} books from database", books.size());
        }
    }

    private void loadUsersFromDatabase() {
        List<User> usersFromDB = dbConnection.findAllDocuments(
            MongoDBConnection.USERS_COLLECTION, 
            User.class
        );
        if (!usersFromDB.isEmpty()) {
            this.users = usersFromDB;
            logger.info("Loaded {} users from database", users.size());
        }
    }

    private void loadLoansFromDatabase() {
        List<Loan> loansFromDB = dbConnection.findAllDocuments(
            MongoDBConnection.LOANS_COLLECTION, 
            Loan.class
        );
        if (!loansFromDB.isEmpty()) {
            this.loans = loansFromDB;
            logger.info("Loaded {} loans from database", loans.size());
        }
    }

    private void createSampleData() {
        logger.info("Creating sample data...");
        
        Book book1 = new Book(
            UUID.randomUUID().toString(),
            "The Little Prince",
            "Antoine de Saint-Exupery",
            "978-3-16-148410-0",
            1943,
            "Fiction"
        );
        
        Book book2 = new Book(
            UUID.randomUUID().toString(),
            "One Hundred Years of Solitude",
            "Gabriel Garcia Marquez",
            "978-0-06-088328-7",
            1967,
            "Novel"
        );
        
        Book book3 = new Book(
            UUID.randomUUID().toString(),
            "The Art of Programming",
            "Donald Knuth",
            "978-0-201-03801-9",
            1968,
            "Computer Science"
        );
        
        add(book1);
        add(book2);
        add(book3);
        
        User user1 = new User(
            UUID.randomUUID().toString(),
            "John",
            "Doe",
            "john.doe@email.com",
            "STUDENT"
        );
        
        User user2 = new User(
            UUID.randomUUID().toString(),
            "Jane",
            "Smith",
            "jane.smith@email.com",
            "PROFESSOR"
        );
        
        addUser(user1);
        addUser(user2);
        
        logger.info("Sample data created successfully");
    }
}
