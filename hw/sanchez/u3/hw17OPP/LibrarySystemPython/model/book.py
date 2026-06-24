class Book:

    def __init__(self, book_id, title, author):
        self._book_id = book_id
        self._title = title
        self._author = author

    @property
    def book_id(self):
        return self._book_id

    @property
    def title(self):
        return self._title

    @property
    def author(self):
        return self._author

    def __str__(self):
        return f"{self.book_id} - {self.title} - {self.author}"