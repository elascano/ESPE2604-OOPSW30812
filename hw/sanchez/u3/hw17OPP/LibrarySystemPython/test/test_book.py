import unittest
from model.book import Book

class TestBook(unittest.TestCase):

    def test_book_creation(self):

        book = Book(
            "1",
            "Python",
            "John"
        )

        self.assertEqual(
            "Python",
            book.title
        )

if __name__ == "__main__":
    unittest.main()