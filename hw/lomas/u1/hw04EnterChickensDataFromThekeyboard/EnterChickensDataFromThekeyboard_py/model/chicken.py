from datetime import datetime

class Chicken:
    def __init__(self, id: int, name: str, color: str, born_on_date: datetime, age: int, is_molting: bool):
        self._id = id
        self._name = name
        self._color = color
        self._born_on_date = born_on_date
        self._age = age
        self._is_molting = is_molting

    def __str__(self):
        return f"Chicken{{id={self._id}, name={self._name}, color={self._color}, bornOnDate={self._born_on_date}, age={self._age}, isMolting={self._is_molting}}}"

    # Getters y Setters
    @property
    def id(self): return self._id
    @id.setter
    def id(self, value): self._id = value

    @property
    def name(self): return self._name
    @name.setter
    def name(self, value): self._name = value

    @property
    def color(self): return self._color
    @color.setter
    def color(self, value): self._color = value

    @property
    def born_on_date(self): return self._born_on_date
    @born_on_date.setter
    def born_on_date(self, value): self._born_on_date = value

    @property
    def age(self): return self._age
    @age.setter
    def age(self, value): self._age = value

    @property
    def is_molting(self): return self._is_molting
    @is_molting.setter
    def is_molting(self, value): self._is_molting = value