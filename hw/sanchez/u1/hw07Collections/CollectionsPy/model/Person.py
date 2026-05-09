# "author": "Joel Sanchez, The Softwarriors, @ESPE"


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
        
        if (current_date.month, current_date.day) < (self.born_on_date.month, self.born_on_date.day):
            age -= 1
        
        return age
    
    def __str__(self):
        is_alive = "YES" if self.alive else "NO"
        return f"Person {self.id} --> Name: {self.full_name}, BirthDate: {self.born_on_date}, alive: {is_alive} <--"
    
    def get_id(self):
        return self.id
    
    def set_id(self, id):
        self.id = id
    
    def get_full_name(self):
        return self.full_name
    
    def set_full_name(self, full_name):
        self.full_name = full_name
    
    def get_born_on_date(self):
        return self.born_on_date
    
    def set_born_on_date(self, born_on_date):
        self.born_on_date = born_on_date
    
    def is_alive(self):
        return self.alive
    
    def set_alive(self, alive):
        self.alive = alive