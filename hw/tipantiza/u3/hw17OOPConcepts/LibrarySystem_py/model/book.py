class Book:
    def __init__(self, id: str = None, title: str = None,
                 author: str = None, isbn: str = None,
                 publication_year: int = None, category: str = None):
        self._id = id
        self._title = title
        self._author = author
        self._isbn = isbn
        self._publication_year = publication_year
        self._available = True
        self._category = category
    
    @property
    def id(self):
        return self._id
    
    @id.setter
    def id(self, value):
        self._id = value
    
    @property
    def title(self):
        return self._title
    
    @title.setter
    def title(self, value):
        self._title = value
    
    @property
    def author(self):
        return self._author
    
    @author.setter
    def author(self, value):
        self._author = value
    
    @property
    def isbn(self):
        return self._isbn
    
    @isbn.setter
    def isbn(self, value):
        self._isbn = value
    
    @property
    def publication_year(self):
        return self._publication_year
    
    @publication_year.setter
    def publication_year(self, value):
        self._publication_year = value
    
    @property
    def available(self):
        return self._available
    
    @available.setter
    def available(self, value):
        self._available = value
    
    @property
    def category(self):
        return self._category
    
    @category.setter
    def category(self, value):
        self._category = value
    
    def borrow(self) -> None:
        if not self._available:
            raise Exception("Book is not available")
        self._available = False
    
    def return_book(self) -> None:
        self._available = True
    
    def __str__(self):
        return f"Book: {self._title} - {self._author} ({self._isbn})"