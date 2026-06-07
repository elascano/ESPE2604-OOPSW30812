from pymongo import MongoClient

class MongoConnection:

    @staticmethod
    def get_database():

        uri = "mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?retryWrites=true&w=majority"

        client = MongoClient(uri)

        return client["hw14MongoDBPy"]