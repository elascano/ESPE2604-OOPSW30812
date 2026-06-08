class Student:

    def __init__(self, id, name, course):
        self.id = id
        self.name = name
        self.course = course

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "course": self.course
        }

    def __str__(self):
        return (f"Student("
                f"id={self.id}, "
                f"name={self.name}, "
                f"course={self.course})")