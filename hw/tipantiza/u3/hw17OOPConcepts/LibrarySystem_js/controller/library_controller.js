const { randomUUID } = require('crypto');

const Book = require('../model/book');
const User = require('../model/user');
const Loan = require('../model/loan');
const IManageable = require('../model/interfaces/manageable');
const MongoDBConnection = require('../utils/mongodb_connection');

class LibraryController extends IManageable {
    constructor() {
        super();
        this._books = [];
        this._users = [];
        this._loans = [];
        this._db = MongoDBConnection.getInstance();
        this._loadInitialData();
    }
    
    add(book) {
        if (!book.id || book.id === "") {
            book.id = randomUUID();
        }
        this._books.push(book);
        this._db.insertDocument(MongoDBConnection.BOOKS_COLLECTION, book);
    }
    
    remove(id) {
        this._books = this._books.filter(book => book.id !== id);
        this._db.deleteDocument(MongoDBConnection.BOOKS_COLLECTION, id);
    }
    
    find(id) {
        return this._books.find(book => book.id === id) || null;
    }
    
    findAll() {
        return [...this._books];
    }
    
    update(book) {
        const index = this._books.findIndex(b => b.id === book.id);
        if (index !== -1) {
            this._books[index] = book;
            this._db.updateDocument(MongoDBConnection.BOOKS_COLLECTION, book.id, book);
        }
    }
    
    addUser(user) {
        if (!user.id || user.id === "") {
            user.id = randomUUID();
        }
        this._users.push(user);
        this._db.insertDocument(MongoDBConnection.USERS_COLLECTION, user);
    }
    
    findUser(id) {
        return this._users.find(user => user.id === id) || null;
    }
    
    findAllUsers() {
        return [...this._users];
    }
    
    removeUser(id) {
        this._users = this._users.filter(user => user.id !== id);
        this._db.deleteDocument(MongoDBConnection.USERS_COLLECTION, id);
    }
    
    updateUser(user) {
        const index = this._users.findIndex(u => u.id === user.id);
        if (index !== -1) {
            this._users[index] = user;
            this._db.updateDocument(MongoDBConnection.USERS_COLLECTION, user.id, user);
        }
    }
    
    createLoan(userId, bookId) {
        const user = this.findUser(userId);
        const book = this.find(bookId);
        
        this._validateLoanRequest(user, book);
        
        const loan = new Loan(
            randomUUID(),
            userId,
            bookId,
            new Date()
        );
        
        this._loans.push(loan);
        book.borrow();
        user.addLoan(bookId);
        
        this._db.insertDocument(MongoDBConnection.LOANS_COLLECTION, loan);
        this.update(book);
        this.updateUser(user);
    }
    
    _validateLoanRequest(user, book) {
        if (!user) {
            throw new Error("User not found");
        }
        if (!book) {
            throw new Error("Book not found");
        }
        if (!book.available) {
            throw new Error(`Book '${book.title}' is not available`);
        }
        if (!user.canBorrow()) {
            throw new Error("User has reached maximum loan limit");
        }
    }
    
    returnLoan(loanId) {
        const loan = this._loans.find(l => l.id === loanId);
        
        if (!loan) {
            throw new Error("Loan not found");
        }
        
        loan.returnDate = new Date();
        loan.status = "RETURNED";
        
        const book = this.find(loan.bookId);
        if (book) {
            book.returnBook();
            this.update(book);
        }
        
        const user = this.findUser(loan.userId);
        if (user) {
            user.returnLoan(loan.bookId);
            this.updateUser(user);
        }
        
        this._db.updateDocument(MongoDBConnection.LOANS_COLLECTION, loanId, loan);
    }
    
    findAllLoans() {
        return [...this._loans];
    }
    
    findActiveLoans() {
        return this._loans.filter(loan => loan.status === "ACTIVE");
    }
    
    findLoansByUser(userId) {
        return this._loans.filter(loan => loan.userId === userId);
    }
    
    getTotalBooks() {
        return this._books.length;
    }
    
    getTotalUsers() {
        return this._users.length;
    }
    
    getActiveLoansCount() {
        return this._loans.filter(loan => loan.status === "ACTIVE").length;
    }
    
    getAvailableBooksCount() {
        return this._books.filter(book => book.available).length;
    }
    
    displayInformation(obj) {
        if (obj instanceof Book) {
            console.log(`Book: ${obj.title} by ${obj.author}`);
        } else if (obj instanceof User) {
            console.log(`User: ${obj.firstName} ${obj.lastName}`);
        } else if (obj instanceof Loan) {
            console.log(`Loan: ${obj.id} - Status: ${obj.status}`);
        }
    }
    
    async _loadInitialData() {
        try {
            await this._loadBooksFromDatabase();
            await this._loadUsersFromDatabase();
            await this._loadLoansFromDatabase();
            
            if (this._books.length === 0 && this._users.length === 0) {
                this._createSampleData();
            }
        } catch (error) {
            console.log(`Error loading initial data: ${error.message}`);
            this._createSampleData();
        }
    }
    
    async _loadBooksFromDatabase() {
        const booksFromDB = await this._db.findAllDocuments(
            MongoDBConnection.BOOKS_COLLECTION,
            Book
        );
        if (booksFromDB.length > 0) {
            this._books = booksFromDB;
            console.log(`Loaded ${this._books.length} books from database`);
        }
    }
    
    async _loadUsersFromDatabase() {
        const usersFromDB = await this._db.findAllDocuments(
            MongoDBConnection.USERS_COLLECTION,
            User
        );
        if (usersFromDB.length > 0) {
            this._users = usersFromDB;
            console.log(`Loaded ${this._users.length} users from database`);
        }
    }
    
    async _loadLoansFromDatabase() {
        const loansFromDB = await this._db.findAllDocuments(
            MongoDBConnection.LOANS_COLLECTION,
            Loan
        );
        if (loansFromDB.length > 0) {
            this._loans = loansFromDB;
            console.log(`Loaded ${this._loans.length} loans from database`);
        }
    }
    
    _createSampleData() {
        console.log("Creating sample data...");
        
        const book1 = new Book(
            randomUUID(),
            "The Little Prince",
            "Antoine de Saint-Exupery",
            "978-3-16-148410-0",
            1943,
            "Fiction"
        );
        
        const book2 = new Book(
            randomUUID(),
            "One Hundred Years of Solitude",
            "Gabriel Garcia Marquez",
            "978-0-06-088328-7",
            1967,
            "Novel"
        );
        
        const book3 = new Book(
            randomUUID(),
            "The Art of Programming",
            "Donald Knuth",
            "978-0-201-03801-9",
            1968,
            "Computer Science"
        );
        
        this.add(book1);
        this.add(book2);
        this.add(book3);
        
        const user1 = new User(
            randomUUID(),
            "John",
            "Doe",
            "john.doe@email.com",
            "STUDENT"
        );
        
        const user2 = new User(
            randomUUID(),
            "Jane",
            "Smith",
            "jane.smith@email.com",
            "PROFESSOR"
        );
        
        this.addUser(user1);
        this.addUser(user2);
        
        console.log("Sample data created successfully");
    }
}

module.exports = LibraryController;