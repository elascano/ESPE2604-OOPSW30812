from database.mongo_connection import MongoConnection

class ComboDAO:

    def __init__(self):
        db = MongoConnection.get_database()
        self.collection = db["combos"]

    def save(self, combo):

        self.collection.insert_one({
            "id": combo.id,
            "name": combo.name,
            "description": combo.description,
            "price": combo.price
        })

    def find_all(self):

        return list(self.collection.find({}, {"_id": 0}))

    def delete(self, id):

        self.collection.delete_one({"id": id})