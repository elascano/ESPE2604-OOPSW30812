class Chicken:
    def __init__(self, id, name, color, age, is_molting):
        self.id = id
        self.name = name
        self.color = color
        self.age = age
        self.is_molting = is_molting

    def __str__(self):
        return f"Chicken{{id={self.id}, name={self.name}, color={self.color}, age={self.age}, is_molting={self.is_molting}}}"

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