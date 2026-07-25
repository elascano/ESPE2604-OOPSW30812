class Book {
    constructor(id = null, title = null, author = null, isbn = null, publicationYear = null, category = null) {
        this._id = id;
        this._title = title;
        this._author = author;
        this._isbn = isbn;
        this._publicationYear = publicationYear;
        this._available = true;
        this._category = category;
    }
    
    get id() {
        return this._id;
    }
    
    set id(value) {
        this._id = value;
    }
    
    get title() {
        return this._title;
    }
    
    set title(value) {
        this._title = value;
    }
    
    get author() {
        return this._author;
    }
    
    set author(value) {
        this._author = value;
    }
    
    get isbn() {
        return this._isbn;
    }
    
    set isbn(value) {
        this._isbn = value;
    }
    
    get publicationYear() {
        return this._publicationYear;
    }
    
    set publicationYear(value) {
        this._publicationYear = value;
    }
    
    get available() {
        return this._available;
    }
    
    set available(value) {
        this._available = value;
    }
    
    get category() {
        return this._category;
    }
    
    set category(value) {
        this._category = value;
    }
    
    borrow() {
        if (!this._available) {
            throw new Error("Book is not available");
        }
        this._available = false;
    }
    
    returnBook() {
        this._available = true;
    }
    
    toString() {
        return `Book: ${this._title} - ${this._author} (${this._isbn})`;
    }
}

module.exports = Book;