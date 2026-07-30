import os
from pymongo import MongoClient


class MongoConnection:
    _client = None
    _database = None
    _connection_string = os.environ.get("MONGODB_URI", "")
    _database_name = "FarmZooDB"

    @classmethod
    def get_database(cls):
        if cls._database is None:
            try:
                cls._client = MongoClient(cls._connection_string)
                cls._database = cls._client[cls._database_name]
            except Exception as e:
                print(f"Error connecting to MongoDB Atlas: {e}")
        return cls._database

    @classmethod
    def save_document(cls, collection_name, document):
        try:
            db = cls.get_database()
            if db is not None:
                db[collection_name].insert_one(document)
        except Exception as e:
            print(f"Error saving document to {collection_name}: {e}")


class FarmBusinessLogic:
    @staticmethod
    def calculate_expected_meat_yield(animal):
        return sum(cut.get_weight() for cut in animal.cut())

    @staticmethod
    def is_eligible_for_egg_production(chicken):
        return not chicken.is_molting() and chicken.get_number_of_eggs_per_week() > 2

    @staticmethod
    def calculate_milk_efficiency(cow):
        if cow.get_weight() <= 0:
            return 0
        return (cow.milk() / cow.get_weight()) * 100
