class Chicken:
    def __init__(self, id, name, color, age, isMolting):
        self.id = id
        self.name = name
        self.color = color
        self.age = age
        self.isMolting = isMolting

    def toString(self):
        return f"Chicken{{id={self.id}, name='{self.name}', color='{self.color}', age={self.age}, isMolting={self.isMolting}}}"
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
    def isMolting(self):
        return self._isMolting
    @isMolting.setter
    def isMolting(self, value):
        self._isMolting = value
    