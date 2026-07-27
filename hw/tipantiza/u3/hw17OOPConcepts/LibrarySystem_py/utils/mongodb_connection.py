from pymongo import MongoClient
from pymongo.collection import Collection
from typing import List, TypeVar, Generic, Type
import json
from datetime import datetime

T = TypeVar('T')

class MongoDBConnection:
    _instance = None
    BOOKS_COLLECTION = "books"
    USERS_COLLECTION = "users"
    LOANS_COLLECTION = "loans"
    
    CONNECTION_STRING = "mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0"
    DATABASE_NAME = "library_sys_db"
    
    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
            cls._instance._initialize()
        return cls._instance
    
    def _initialize(self):
        try:
            self._client = MongoClient(self.CONNECTION_STRING)
            self._database = self._client[self.DATABASE_NAME]
            self._database.list_collection_names()
            print(f"Connected successfully to MongoDB: {self.DATABASE_NAME}")
        except Exception as e:
            print(f"Error connecting to MongoDB: {e}")
            raise Exception("Failed to connect to MongoDB")
    
    def get_collection(self, collection_name: str) -> Collection:
        return self._database[collection_name]
    
    def _to_dict(self, obj) -> dict:
        if hasattr(obj, '__dict__'):
            result = {}
            for key, value in obj.__dict__.items():
                if key.startswith('_'):
                    clean_key = key[1:]
                else:
                    clean_key = key
                if isinstance(value, datetime):
                    result[clean_key] = value.isoformat()
                else:
                    result[clean_key] = value
            return result
        return obj.__dict__
    
    def insert_document(self, collection_name: str, entity) -> None:
        try:
            collection = self.get_collection(collection_name)
            document = self._to_dict(entity)
            collection.insert_one(document)
        except Exception as e:
            print(f"Error inserting document: {e}")
            raise Exception("Error inserting document")
    
    def find_all_documents(self, collection_name: str, entity_class: Type[T]) -> List[T]:
        results = []
        try:
            collection = self.get_collection(collection_name)
            cursor = collection.find()
            
            for document in cursor:
                entity = entity_class()
                for key, value in document.items():
                    if hasattr(entity, f'_{key}'):
                        setattr(entity, f'_{key}', value)
                    elif hasattr(entity, key):
                        setattr(entity, key, value)
                results.append(entity)
        except Exception as e:
            print(f"Error retrieving documents: {e}")
        return results
    
    def find_document_by_id(self, collection_name: str, id: str, entity_class: Type[T]) -> T:
        try:
            collection = self.get_collection(collection_name)
            document = collection.find_one({"id": id})
            
            if document:
                entity = entity_class()
                for key, value in document.items():
                    if hasattr(entity, f'_{key}'):
                        setattr(entity, f'_{key}', value)
                    elif hasattr(entity, key):
                        setattr(entity, key, value)
                return entity
        except Exception as e:
            print(f"Error finding document by ID: {e}")
        return None
    
    def update_document(self, collection_name: str, id: str, entity) -> None:
        try:
            collection = self.get_collection(collection_name)
            document = self._to_dict(entity)
            collection.update_one({"id": id}, {"$set": document})
        except Exception as e:
            print(f"Error updating document: {e}")
            raise Exception("Error updating document")
    
    def delete_document(self, collection_name: str, id: str) -> None:
        try:
            collection = self.get_collection(collection_name)
            collection.delete_one({"id": id})
        except Exception as e:
            print(f"Error deleting document: {e}")
            raise Exception("Error deleting document")
    
    def is_connected(self) -> bool:
        try:
            self._database.list_collection_names()
            return True
        except Exception:
            return False
    
    def close(self) -> None:
        if self._client:
            self._client.close()
            print("MongoDB connection closed")