from datetime import date

class Person:
    def __init__(self, id, full_name, born_on_date, alive):
        self.__id = id
        self.__full_name = full_name
        self.__born_on_date = born_on_date
        self.__alive = alive

    def compute_age(self):
        current_date = date.today()
        age = current_date.year - self.__born_on_date.year
        
        if (current_date.month, current_date.day) < (self.__born_on_date.month, self.__born_on_date.day):
            age -= 1
            
        return age

    def __str__(self):
        is_alive = "YES" if self.__alive else "NO"
        return f"Person{{id={self.__id}, fullName={self.__full_name}, bornOnDate={self.__born_on_date}, alive={self.__alive}}}"

    @property
    def id(self):
        return self.__id

    @id.setter
    def id(self, value):
        self.__id = value

    @property
    def full_name(self):
        return self.__full_name

    @full_name.setter
    def full_name(self, value):
        self.__full_name = value

    @property
    def born_on_date(self):
        return self.__born_on_date

    @born_on_date.setter
    def born_on_date(self, value):
        self.__born_on_date = value

    @property
    def alive(self):
        return self.__alive

    @alive.setter
    def alive(self, value):
        self.__alive = value