from datetime import date


class Person:

    def __init__(self, id, full_name, born_on_date, alive):
        self.id = id
        self.full_name = full_name
        self.born_on_date = born_on_date
        self.alive = alive

    def compute_age_in_years(self):
        current_date = date.today()

        age = current_date.year - self.born_on_date.year

        # Verifica si aún no ha cumplido años este año
        if (current_date.month, current_date.day) < (
                self.born_on_date.month,
                self.born_on_date.day):
            age -= 1

        return age

    def __str__(self):
        is_alive = "YES" if self.alive else "NO"

        return (f"Person {self.id} --> "
                f"Name:{self.full_name}, "
                f"BirthDate:{self.born_on_date}, "
                f"alive:{is_alive} <--")