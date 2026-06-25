class Library {

    constructor() {
        this.books = [];
        this.members = [];
    }

    addBook(book) {
        this.books.push(book);
    }

    addMember(member) {
        this.members.push(member);
    }
}

module.exports = Library;