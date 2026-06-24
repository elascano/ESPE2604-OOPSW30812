const { client } = require("../utils/MongoConnection");
const Book = require("../model/Book");

class MongoBookDAO {

    async getCollection() {
        if (!client.topology || !client.topology.isConnected()) {
            await client.connect();
        }
        const db = client.db("libraryDB");
        return db.collection("books");
    }

    async save(book) {
        const collection = await this.getCollection();
        await collection.insertOne({
            bookId: book.bookId,
            title: book.title,
            author: book.author
        });
    }

    async findAll() {
        const collection = await this.getCollection();
        const docs = await collection.find().toArray();
        return docs.map(d =>
            new Book(d.bookId, d.title, d.author)
        );
    }

    async findById(id) {
        const collection = await this.getCollection();
        const d = await collection.findOne({ bookId: id });
        if (!d) return null;
        return new Book(d.bookId, d.title, d.author);
    }

    async update(book) {
        const collection = await this.getCollection();
        await collection.updateOne(
            { bookId: book.bookId },
            { $set: { title: book.title, author: book.author } }
        );
    }

    async delete(id) {
        const collection = await this.getCollection();
        await collection.deleteOne({ bookId: id });
    }
}

module.exports = MongoBookDAO;