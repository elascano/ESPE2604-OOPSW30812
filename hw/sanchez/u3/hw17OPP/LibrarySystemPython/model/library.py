class Library:

    def __init__(self):
        self._books = []
        self._members = []

    def add_book(self, book):
        self._books.append(book)

    def add_member(self, member):
        self._members.append(member)