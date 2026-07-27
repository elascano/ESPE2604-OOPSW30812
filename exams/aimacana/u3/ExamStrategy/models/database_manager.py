import pymongo
from pymongo import MongoClient
from typing import List, Dict, Any, Optional


class DatabaseManager:

    DB_NAME = "strategyAimacana"
    COLLECTION_NAME = "arrayAriel"
    DEFAULT_URI = "mongodb://admin:AZaxnebula18*@157.137.223.54:27017/admin"

    def __init__(self, uri: str = DEFAULT_URI):
        self.uri = uri
        self.client: Optional[MongoClient] = None
        self.is_connected = False
        self.local_memory_backup: List[Dict[str, Any]] = []
        self.connect()

    def connect(self) -> bool:
        try:
            self.client = MongoClient(self.uri, serverSelectionTimeoutMS=3000)
            self.client.admin.command('ping')
            self.is_connected = True
            return True
        except Exception:
            self.is_connected = False
            return False

    def save_sort_record(self, unsorted_str: str, size: int, sort_algorithm: str, sorted_str: str) -> Dict[str, Any]:
        record = {
            "unsorted": unsorted_str,
            "size": size,
            "sort algorithm": sort_algorithm,
            "sorted": sorted_str
        }

        if self.is_connected and self.client:
            try:
                db = self.client[self.DB_NAME]
                collection = db[self.COLLECTION_NAME]
                result = collection.insert_one(dict(record))
                record["_id"] = str(result.inserted_id)
            except Exception:
                self.local_memory_backup.append(record)
        else:
            self.local_memory_backup.append(record)

        return record

    def fetch_all_records(self) -> List[Dict[str, Any]]:
        records = []
        if self.is_connected and self.client:
            try:
                db = self.client[self.DB_NAME]
                collection = db[self.COLLECTION_NAME]
                cursor = collection.find().sort("_id", pymongo.DESCENDING)
                for doc in cursor:
                    doc["_id"] = str(doc.get("_id", ""))
                    records.append(doc)
                return records
            except Exception:
                pass

        return list(reversed(self.local_memory_backup))
