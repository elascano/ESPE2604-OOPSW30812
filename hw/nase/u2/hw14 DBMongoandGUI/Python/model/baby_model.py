from model.mongo_connection import MongoConnection

class BabyModel:
    def __init__(self):
        self.db = MongoConnection.get_database()
        self.collection = self.db["babies"]

    def save_baby(self, baby_data):
        baby_id = f"{baby_data['firstName']}_{baby_data['lastName']}"
        document = {
            "_id": baby_id,
            "firstName": baby_data["firstName"],
            "lastName": baby_data["lastName"],
            "weight": baby_data["weight"],
            "height": baby_data["height"],
            "birthDate": baby_data["birthDate"],
            "motherId": baby_data["motherId"]
        }
        return self.collection.replace_one({"_id": baby_id}, document, upsert=True)

    def get_baby_by_mother(self, mother_id):
        return self.collection.find_one({"motherId": mother_id})