const express = require("express");
const router = express.Router();

const Book = require("../model/Book");
const MongoBookDAO = require("../dao/MongoBookDAO");
const BookController = require("../controller/BookController");

const controller = new BookController(new MongoBookDAO());

router.post("/", async (req, res) => {
    try {
        const book = new Book(req.body.bookId, req.body.title, req.body.author);
        await controller.saveBook(book);
        res.json({ message: "Book saved" });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

router.get("/", async (req, res) => {
    try {
        const books = await controller.getAllBooks();
        res.json(books);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

router.get("/:id", async (req, res) => {
    try {
        const book = await controller.getBookById(req.params.id);
        if (!book) {
            return res.status(404).json({ error: "Book not found" });
        }
        res.json(book);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

router.put("/:id", async (req, res) => {
    try {
        const book = new Book(req.params.id, req.body.title, req.body.author);
        await controller.updateBook(book);
        res.json({ message: "Book updated" });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

router.delete("/:id", async (req, res) => {
    try {
        await controller.deleteBook(req.params.id);
        res.json({ message: "Book deleted" });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

module.exports = router;