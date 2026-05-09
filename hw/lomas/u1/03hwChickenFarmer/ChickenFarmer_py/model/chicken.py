class Chicken:
    def __init__(self, id, name, color, age, is_molting):
        self.id = id
        self.name = name
        self.color = color
        self.age = age
        self.is_molting = is_molting

    def __str__(self):
        
        molting_str = "Yes" if self.is_molting else "No"
        return (f"Chicken [ID={self.id}, Name={self.name}, "
                f"Color={self.color}, Age={self.age}, Molting={molting_str}]")
