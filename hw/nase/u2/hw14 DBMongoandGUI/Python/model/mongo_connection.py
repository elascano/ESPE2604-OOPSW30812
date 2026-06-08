from pymongo import MongoClient

class MongoConnection:
    _client = None

    @classmethod
    def get_database(cls):
        if cls._client is None:
            uri = "mongodb+srv://Jennyfer:jennyfer@jennyfer.owlaicw.mongodb.net/?appName=Jennyfer"

            cls._client = MongoClient(uri)
        return cls._client["MothersAppDB"]