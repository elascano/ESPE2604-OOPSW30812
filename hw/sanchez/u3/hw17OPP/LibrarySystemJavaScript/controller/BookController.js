class BookController {

    constructor(dao) {
        this.dao = dao;
    }

    async saveBook(book) {
        await this.dao.save(book);
    }

    async getAllBooks() {
        return await this.dao.findAll();
    }

    async getBookById(id) {
        return await this.dao.findById(id);
    }

    async updateBook(book) {
        await this.dao.update(book);
    }

    async deleteBook(id) {
        await this.dao.delete(id);
    }
}

module.exports = BookController;