class Chicken:
    def __init__(self, id, name, color, age, molting):
        self.id = id
        self.name = name
        self.color = color
        self.age = age
        self.is_molting = molting

    def __str__(self):
        return f"Chicken({self.id}, {self.name})"