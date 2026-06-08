class Chicken:
    def __init__(self, id, name, color, age, is_molting):
        self.__id = id
        self.__name = name
        self.__color = color
        self.__age = age
        self.__is_molting = is_molting

    def __str__(self):
        return f"Chicken{{id={self.__id}, name={self.__name}, color={self.__color}, age={self.__age}, is_molting={self.__is_molting}}}"

    @property
    def id(self):
        return self.__id

    @id.setter
    def id(self, value):
        self.__id = value

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, value):
        self.__name = value

    @property
    def color(self):
        return self.__color

    @color.setter
    def color(self, value):
        self.__color = value

    @property
    def age(self):
        return self.__age

    @age.setter
    def age(self, value):
        self.__age = value

    @property
    def is_molting(self):
        return self.__is_molting

    @is_molting.setter
    def is_molting(self, value):
        self.__is_molting = value
