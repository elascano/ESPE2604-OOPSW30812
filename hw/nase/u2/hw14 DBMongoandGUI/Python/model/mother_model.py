from model.mongo_connection import MongoConnection

class MotherModel:
    def __init__(self):
        self.db = MongoConnection.get_database()
        self.collection = self.db["Mother"]

    def save_mother(self, mother_data, baby_data):
        mother_id = mother_data["id"]
        document = {
            "firstName": mother_data["firstName"],
            "lastName": mother_data["lastName"],
            "id": mother_id,
            "birthDate": mother_data["birthDate"],
            "weight": mother_data["weight"],
            "height": mother_data["height"],
            "babies": [baby_data] 
        }
        return self.collection.replace_one({"id": mother_id}, document, upsert=True)