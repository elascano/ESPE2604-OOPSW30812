from utils.mongo_connection import MongoConnection


class MongoController:

    def save_animal(self, animal):

        database = MongoConnection.database

        collection = database["animals"]

        data = {
            "id": animal.id,
            "breed": animal.breed,
            "weight": animal.weight
        }

        collection.insert_one(data)

        print("Animal saved")