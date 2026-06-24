from abc import ABC, abstractmethod

class BookDAO(ABC):

    @abstractmethod
    def save(self, book):
        pass

    @abstractmethod
    def find_all(self):
        pass

    @abstractmethod
    def find_by_id(self, book_id):
        pass

    @abstractmethod
    def update(self, book):
        pass

    @abstractmethod
    def delete(self, book_id):
        pass