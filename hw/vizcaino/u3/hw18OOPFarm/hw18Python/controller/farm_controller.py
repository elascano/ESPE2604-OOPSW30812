from utils.mongo_connection import MongoConnection


class FarmController:
    def __init__(self):
        self.db = MongoConnection()

    def create(self, t, a):
        return self.db.insert(t, a)

    def read(self, t):
        return self.db.get_all(t)

    def update(self, t, a):
        return self.db.update(t, a["id"], a)

    def delete(self, t, id_):
        return self.db.delete(t, id_)

    def action(self, t, id_, field, action):
        return self.db.action(t, id_, field, action)