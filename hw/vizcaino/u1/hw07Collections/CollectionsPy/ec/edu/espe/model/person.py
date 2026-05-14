from datetime import date

class Person:
    def __init__(self, id, name, born_on_date, alive):
        self.id = id
        self.name = name
        self.born_on_date = born_on_date
        self.alive = alive

    def compute_age_in_years(self):
        today = date.today()
        age = today.year - self.born_on_date.year

        if (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day):
            age -= 1

        return age

    def __str__(self):
        return f"Person{{id={self.id}, name={self.name}, bornOnDate={self.born_on_date}, alive={str(self.alive).lower()}}}"

    def __repr__(self):
        return self.__str__()