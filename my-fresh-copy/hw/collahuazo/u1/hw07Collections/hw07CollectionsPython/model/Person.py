from datetime import date

class Person:
    def __init__(self, id: int, full_name: str, born_on_date: date, alive: bool):
        self.id = id
        self.full_name = full_name
        self.born_on_date = born_on_date
        self.alive = alive
        
    def compute_age_in_years(self) -> int:
        current_date = date.today()
        age = current_date.year - self.born_on_date.year
    
        return age

    def __str__(self):
        is_alive = "YES" if self.alive else "NO"
        return f"Person {self.id} --> Name:{self.full_name}, BirthDate:{self.born_on_date}, alive:{is_alive} <--"