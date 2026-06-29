from pymongo import MongoClient


class MongoConnection:
    def __init__(self):
        self.client = MongoClient("mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?appName=Cluster0")
        self.db = self.client["hw18Python"]

        self.collections = {
            "Pig": self.db["Pig"],
            "Cow": self.db["Cow"],
            "Chicken": self.db["Chicken"],
            "Sheep": self.db["Sheep"]
        }

    def insert(self, t, data):
        return self.collections[t].insert_one(data)

    def get_all(self, t):
        return list(self.collections[t].find())

    def update(self, t, id_, data):
        return self.collections[t].update_one({"id": id_}, {"$set": data})

    def delete(self, t, id_):
        return self.collections[t].delete_one({"id": id_})

    def action(self, t, id_, field, action):
        return self.collections[t].update_one(
            {"id": id_},
            {"$inc": {field: 1}, "$push": {"history": action}}
        )