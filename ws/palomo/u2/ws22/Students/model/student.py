class Student:

    def __init__(self, student_id, name, grade1, grade2):
        self.student_id = student_id
        self.name = name
        self.grade1 = grade1
        self.grade2 = grade2

    def calculate_average(self):
        return (self.grade1 + self.grade2) / 2

    def __str__(self):
        return (f"ID: {self.student_id} | "
                f"Name: {self.name} | "
                f"Average: {self.calculate_average():.2f}")