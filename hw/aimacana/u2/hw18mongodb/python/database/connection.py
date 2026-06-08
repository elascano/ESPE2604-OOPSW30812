import pymongo

class MongoDBConnection:
    _client = None
    _db = None
    CONNECTION_STRING = "mongodb://mongodb:mongodb@157.137.223.54:27017/mongodb?authSource=mongodb"
    DATABASE_NAME = "mongodb"

    @classmethod
    def get_database(cls):
        if cls._db is None:
            cls._client = pymongo.MongoClient(cls.CONNECTION_STRING, serverSelectionTimeoutMS=3000)
            cls._db = cls._client[cls.DATABASE_NAME]
        return cls._db

    @classmethod
    def close(cls):
        if cls._client is not None:
            cls._client.close()
            cls._client = None
            cls._db = None
