import pymongo

class DatabaseRepository:
    def __init__(self, uri):
        self.col = pymongo.MongoClient(uri)["strategyJennyfer"]["arrayJennyfer"]

    def save(self, u, sz, algo, s):
        self.col.insert_one({"unsorted": u, "size": sz, "sort algorithm": algo, "sorted": s})