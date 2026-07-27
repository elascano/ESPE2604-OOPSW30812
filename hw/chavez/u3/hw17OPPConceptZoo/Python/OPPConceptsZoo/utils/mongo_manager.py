from utils.mongo_connection import MongoConnection


class MongoManager:

    def save_animal(self, animal):

        collection = MongoConnection.database["animals"]

        data = {
            "id": animal.id,
            "breed": animal.breed,
            "weight": animal.weight
        }

        collection.insert_one(data)

        print("Animal saved successfully")

    def save_food(self, food):

        collection = MongoConnection.database["food"]

        data = {
            "id": food.id,
            "description": food.description
        }

        collection.insert_one(data)

        print("Food saved successfully")