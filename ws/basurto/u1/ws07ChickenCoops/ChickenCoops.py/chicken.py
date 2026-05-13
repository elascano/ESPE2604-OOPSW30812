//author Jennyfer Nase
class Chicken:
    def __init__(self, id, name, color, age, molting, born_date):
        self.id = id
        self.name = name
        self.color = color
        self.born_date = born_date  
        self.age = age
        self.is_molting = molting

    def __str__(self):
        molting_str = str(self.is_molting).lower()
        return (f"Chicken{{id={self.id}, name={self.name}, color={self.color}, "
                f"bornOnDate={self.born_date}, age={self.age}, IsMolting={molting_str}}}")