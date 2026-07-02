from pymongo import MongoClient


class MongoConnection:

    URI = "mongodb+srv://daniel:daniel1234@cluster0.zfwd5wx.mongodb.net/?appName=Cluster0"
    DATABASE_NAME = "FarmPy"

    _database = None

    @staticmethod
    def get_database():

        try:

            if MongoConnection._database is None:

                client = MongoClient(MongoConnection.URI)

                MongoConnection._database = client[MongoConnection.DATABASE_NAME]

                print("Connected to MongoDB")

        except Exception as e:

            print(f"Error connecting to MongoDB: {e}")

        return MongoConnection._database