from dao.book_dao import BookDAO
from model.book import Book
from utils.mongo_connection import MongoConnection

class MongoBookDAO(BookDAO):

    def __init__(self):
        db = MongoConnection.get_database()
        self.collection = db["books"]

    def save(self, book):

        self.collection.insert_one({
            "bookId": book.book_id,
            "title": book.title,
            "author": book.author
        })

    def find_all(self):

        books = []

        for d in self.collection.find():

            books.append(
                Book(
                    d["bookId"],
                    d["title"],
                    d["author"]
                )
            )

        return books

    def find_by_id(self, book_id):

        d = self.collection.find_one(
            {"bookId": book_id}
        )

        if d is None:
            return None

        return Book(
            d["bookId"],
            d["title"],
            d["author"]
        )

    def update(self, book):

        self.collection.update_one(
            {"bookId": book.book_id},
            {
                "$set": {
                    "title": book.title,
                    "author": book.author
                }
            }
        )

    def delete(self, book_id):

        self.collection.delete_one(
            {"bookId": book_id}
        )