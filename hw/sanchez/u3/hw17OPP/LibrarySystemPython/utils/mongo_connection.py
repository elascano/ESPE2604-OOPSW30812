from pymongo import MongoClient

class MongoConnection:

    client = MongoClient(
        "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?appName=Cluster0"
    )

    database = client["libraryDB"]

    @staticmethod
    def get_database():
        return MongoConnection.database