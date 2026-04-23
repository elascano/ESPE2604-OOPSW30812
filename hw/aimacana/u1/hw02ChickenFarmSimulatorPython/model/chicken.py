class Chicken:
    def __init__(self, id: int, name: str, color: str, age: int, is_molting: bool):
        self._id = id
        self._name = name
        self._color = color
        self._age = age
        self._is_molting = is_molting

    def __str__(self):
        return f"Chicken{{id={self._id}, name={self._name}, color={self._color}, age={self._age}, is_molting={self._is_molting}}}"

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

    @property
    def color(self):
        return self._color

    @color.setter
    def color(self, value):
        self._color = value

    @property
    def age(self):
        return self._age

    @age.setter
    def age(self, value):
        self._age = value

    @property
    def is_molting(self):
        return self._is_molting

    @is_molting.setter
    def is_molting(self, value):
        self._is_molting = value
