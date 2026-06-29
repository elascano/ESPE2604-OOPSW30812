from pymongo import MongoClient

class Database:

    def __init__(self):

        self.client = MongoClient(
            "mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?retryWrites=true&w=majority"
        )

        self.db = self.client["hw17Python"]

    def users(self):
        return self.db["users"]