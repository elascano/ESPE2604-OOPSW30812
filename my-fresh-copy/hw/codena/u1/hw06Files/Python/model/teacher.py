class Teacher:

    def __init__(self, id, name, career):
        self.id = id
        self.name = name
        self.career = career

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "career": self.career
        }

    def __str__(self):
        return (f"Teacher("
                f"id={self.id}, "
                f"name={self.name}, "
                f"career={self.career})")