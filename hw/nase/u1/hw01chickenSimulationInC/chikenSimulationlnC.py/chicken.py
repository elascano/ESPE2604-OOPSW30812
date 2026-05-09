class Chicken:
    def __init__(self, name, age):
        self.name = name
        self.age_in_months = age
        self.daily_food = 50
        self.egg_counter = 0

    def __str__(self):
        return f"Chicken{{name={self.name}, age={self.age_in_months}, food={self.daily_food}, eggs={self.egg_counter}}}"