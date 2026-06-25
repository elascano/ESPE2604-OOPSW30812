class BookController:

    def __init__(self, dao):
        self.dao = dao

    def save_book(self, book):
        self.dao.save(book)

    def get_all_books(self):
        return self.dao.find_all()

    def get_book_by_id(self, book_id):
        return self.dao.find_by_id(book_id)

    def update_book(self, book):
        self.dao.update(book)

    def delete_book(self, book_id):
        self.dao.delete(book_id)