from pymongo import MongoClient
from datetime import datetime

class DoctorModel:
    def __init__(self):
        self.uri = "mongodb+srv://Angie:Angie@angienx.spphrbg.mongodb.net/MothersAppDB?retryWrites=true&w=majority"
        self.client = MongoClient(self.uri)
        self.db = self.client["MothersAppDB"]
        self.collection = self.db["allProjectRecords"]

    def save_doctor(self, doctor_id, name, speciality):
        if not doctor_id or not name:
            return {"status": "error", "message": "Fields cannot be empty."}

        try:
            id_int = int(doctor_id)
            
            doctor_data = {
                "id": id_int,
                "name": name,
                "speciality": speciality
            }

            final_json = {
                "module": "Doctor Registration",
                "syncDate": str(datetime.now()),
                "doctorData": doctor_data
            }

            self.collection.insert_one(final_json)
            return {"status": "success", "message": "Doctor data saved directly to Cloud!"}

        except ValueError:
            return {"status": "error", "message": "ID must be a valid integer number."}
        except Exception as e:
            return {"status": "error", "message": f"Cloud Error: {str(e)}"}