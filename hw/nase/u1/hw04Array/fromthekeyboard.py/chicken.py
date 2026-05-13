from datetime import datetime

class Chicken:  # <--- Asegúrate de que la C sea mayúscula
    def __init__(self, id, name, color, age, is_molting):
        self.id = id
        self.name = name
        self.color = color
        self.born_on_date = datetime.now()
        self.age = age
        self.is_molting = is_molting

    def __str__(self):
        return f"Chicken{{id={self.id}, name={self.name}, color={self.color}, age={self.age}, isMolting={self.is_molting}}}"