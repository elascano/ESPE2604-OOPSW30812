# author Jennyfer Nase
class Person:
    def __init__(self, id, full_name, born_on_date, alive):
        self.id = id
        self.full_name = full_name
        self.born_on_date = born_on_date
        self.alive = alive

    def __repr__(self):
      
        alive_str = str(self.alive).lower()
        return f"Person{{id={self.id}, fullName={self.full_name}, bornOnDate={self.born_on_date}, alive={alive_str}}}"

    def __str__(self):
       
        alive_str = str(self.alive).lower()
        return f"Person{{id={self.id}, fullName={self.full_name}, bornOnDate={self.born_on_date}, alive={alive_str}}}"