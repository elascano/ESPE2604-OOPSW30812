from utils.mongo_connection import MongoConnection
from model.food import Food


class FoodController:

    def __init__(self):

        database = MongoConnection.get_database()

        self.collection = database["foods"]

    def create(self, food):

        document = {"_id": food.id , "typeOfFood": food.type_of_food}

        self.collection.insert_one(document)

    def update(self, food):

        self.collection.update_one(
            {"_id": food.id},
            {"$set": {"typeOfFood": food.type_of_food}}
        )

    def delete(self, id):

        self.collection.delete_one({"_id": id})

    def read(self):

        foods = []

        documents = self.collection.find()

        for document in documents:

            food = Food(
                document["_id"],
                document["typeOfFood"]
            )

            foods.append(food)

        return foods

    def find_by_id(self, id):

        document = self.collection.find_one({"_id": id})

        if document is None:

            return None

        return Food(
            document["_id"],
            document["typeOfFood"]
        )