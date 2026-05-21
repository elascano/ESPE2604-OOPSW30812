from datetime import date


class Chicken:

    def __init__(self, id, name, color, born_on_date, age, is_molting):
        self.id = id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date
        self.age = age
        self.is_molting = is_molting

    def __str__(self):
        return (f"Chicken{{id={self.id}, "
                f"name={self.name}, "
                f"color={self.color}, "
                f"born_on_date={self.born_on_date}, "
                f"age={self.age}, "
                f"is_molting={self.is_molting}}}")