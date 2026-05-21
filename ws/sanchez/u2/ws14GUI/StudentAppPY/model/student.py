class Student:
    def __init__(self, id_number="", name="", age=0, career="", grades=None):
        self.id_number = id_number
        self.name = name
        self.age = age
        self.career = career
        self.grades = grades if grades is not None else []

    def get_id_number(self):
        return self.id_number

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def get_career(self):
        return self.career

    def get_grades(self):
        return self.grades

    def calculate_gpa(self):
        if not self.grades:
            return 0
        return sum(self.grades) / len(self.grades)