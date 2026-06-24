from abc import ABC, abstractmethod

class Person(ABC):

    def __init__(self, person_id, name):
        self._id = person_id
        self._name = name

    @abstractmethod
    def get_info(self):
        pass