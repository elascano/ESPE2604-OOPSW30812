from pymongo import MongoClient
from pymongo.errors import PyMongoError


class DBConnection:
    CONNECTION_STRING = "mongodb+srv://brandon:Brandon2026@cluster0.evr08tq.mongodb.net/?appName=Cluster0"

    DB_NAME = "strategyCollahuazo"
    COLLECTION_NAME = "arrayBrandon"

    def __init__(self):
        self.client = None
        self.collection = None
        self._connect()

    def _connect(self) -> None:
        try:
            self.client = MongoClient(self.CONNECTION_STRING, serverSelectionTimeoutMS=5000)
            self.client.admin.command("ping")
            db = self.client[self.DB_NAME]
            self.collection = db[self.COLLECTION_NAME]
            print(f"Connected to MongoDB Atlas: {self.DB_NAME}.{self.COLLECTION_NAME}")
        except PyMongoError as e:
            print(f"[ERROR] Could not connect to MongoDB Atlas: {e}")
            self.client = None
            self.collection = None

    def insert_record(self, record_dict: dict):
        if self.collection is None:
            print("[WARNING] No database connection; the record was not saved remotely.")
            return None
        try:
            result = self.collection.insert_one(record_dict)
            return result.inserted_id
        except PyMongoError as e:
            print(f"[ERROR] Could not insert the record: {e}")
            return None
