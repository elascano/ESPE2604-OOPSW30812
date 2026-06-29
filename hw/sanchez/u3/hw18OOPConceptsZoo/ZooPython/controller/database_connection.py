import os
from pymongo import MongoClient
from pymongo.collection import Collection
from dotenv import load_dotenv

load_dotenv()

class DatabaseConnection:
    _instance = None
    
    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
            cls._instance._initialize()
        return cls._instance
    
    def _initialize(self):
        self.connection_string = os.getenv('MONGODB_URI')
        self.database_name = os.getenv('DATABASE_NAME', 'OOPConceptsZoo')
        try:
            self.client = MongoClient(self.connection_string)
            self.database = self.client[self.database_name]
            print("Connected to MongoDB Atlas")
        except Exception as e:
            print(f"Error connecting to MongoDB Atlas: {e}")
    
    def get_collection(self, collection_name: str) -> Collection:
        return self.database[collection_name]
    
    def is_connected(self) -> bool:
        try:
            self.database.list_collection_names()
            return True
        except Exception:
            return False
    
    def close(self):
        if self.client:
            self.client.close()