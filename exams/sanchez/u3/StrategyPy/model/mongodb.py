from pymongo import MongoClient
import certifi
import config


class MongoDB:

    def __init__(self):

        self.client = MongoClient(
            config.MONGO_URI,
            tlsCAFile=certifi.where()
        )

        self.db = self.client[config.DATABASE]
        self.collection = self.db[config.COLLECTION]

    def save(self, unsorted, size, algorithm, sorted_numbers):

        document = {
            "unsorted": ",".join(map(str, unsorted)),
            "size": size,
            "sort algorithm": algorithm,
            "sorted": ",".join(map(str, sorted_numbers))
        }

        self.collection.insert_one(document)