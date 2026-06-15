class Grade:
    def __init__(self, student_id, value):
        if value < 0 or value > 20:
            raise ValueError("Grade must be between 0 and 20.")
        self.student_id = student_id
        self.value = value

    def to_dict(self):
        return {"studentId": self.student_id, "value": self.value}

    @staticmethod
    def from_dict(data):
        return Grade(data.get("studentId", ""), float(data.get("value", 0)))
