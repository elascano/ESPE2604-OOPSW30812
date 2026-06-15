class Student:
    def __init__(self, student_id, first_name, last_name, phone_number):
        self.id = student_id
        self.first_name = first_name
        self.last_name = last_name
        self.phone_number = phone_number

    def to_dict(self):
        return {
            "id": self.id,
            "firstName": self.first_name,
            "lastName": self.last_name,
            "phoneNumber": self.phone_number,
        }

    @staticmethod
    def from_dict(data):
        return Student(
            data.get("id", ""),
            data.get("firstName", ""),
            data.get("lastName", ""),
            data.get("phoneNumber", ""),
        )
