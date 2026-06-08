from model.mongo_connection import MongoConnection

class AppointmentModel:
    def __init__(self):
        self.db = MongoConnection.get_database()
        self.collection = self.db["appointments"]

    def save_appointment(self, appointment_data):
        document = {
            "appointmentDate": appointment_data["appointmentDate"],
            "recommendations": appointment_data["recommendations"],
            "motherId": appointment_data["motherId"]
        }
        return self.collection.insert_one(document)

    def get_appointment_by_mother(self, mother_id):
        return self.collection.find_one({"motherId": mother_id}, sort=[("_id", -1)])