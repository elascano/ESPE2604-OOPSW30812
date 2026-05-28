class Student:
    def __init__(self, first_name="", last_name="", subject="", age=0, grades=None):
        self._first_name = first_name
        self._last_name = last_name
        self._subject = subject
        self._age = age
        self._grades = grades if grades is not None else []

    def get_average(self):
        if not self._grades:
            return 0
        return sum(self._grades) / len(self._grades)

    def __str__(self):
        return (f"\nName: {self._first_name} {self._last_name}\n"
                f"Subject: {self._subject}\n"
                f"Age: {self._age}\n"
                f"Grades: {self._grades}\n"
                f"Average: {self.get_average():.2f}")

    # Getters
    def get_first_name(self):
        return self._first_name

    def get_last_name(self):
        return self._last_name

    def get_subject(self):
        return self._subject

    def get_age(self):
        return self._age

    def get_grades(self):
        return self._grades

    # Setters
    def set_first_name(self, first_name):
        self._first_name = first_name

    def set_last_name(self, last_name):
        self._last_name = last_name

    def set_subject(self, subject):
        self._subject = subject

    def set_age(self, age):
        self._age = age

    def set_grades(self, grades):
        self._grades = grades