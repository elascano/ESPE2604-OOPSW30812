from abc import ABC, abstractmethod

class Person(ABC):
    def __init__(self, id: str = None, first_name: str = None, 
                 last_name: str = None, email: str = None):
        self._id = id
        self._first_name = first_name
        self._last_name = last_name
        self._email = email
    
    @property
    def id(self):
        return self._id
    
    @id.setter
    def id(self, value):
        self._id = value
    
    @property
    def first_name(self):
        return self._first_name
    
    @first_name.setter
    def first_name(self, value):
        self._first_name = value
    
    @property
    def last_name(self):
        return self._last_name
    
    @last_name.setter
    def last_name(self, value):
        self._last_name = value
    
    @property
    def email(self):
        return self._email
    
    @email.setter
    def email(self, value):
        self._email = value
    
    @abstractmethod
    def get_person_type(self) -> str:
        pass
    
    def get_full_name(self) -> str:
        return f"{self._first_name} {self._last_name}"
    
    def __str__(self):
        return f"{self.get_full_name()} ({self._email})"