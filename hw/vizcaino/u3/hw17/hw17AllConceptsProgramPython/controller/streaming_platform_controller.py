from utils.database import Database

class StreamingPlatformController:

    def __init__(self):
        self.collection = Database().users()

    def create_user(self, user):
        self.collection.insert_one(user.to_dict())

    def get_users(self):
        return list(self.collection.find({}, {"_id": 0}))

    def update_user(self, name, new_plan):
        self.collection.update_one(
            {"name": name},
            {"$set": {"plan": new_plan}}
        )

    def delete_user(self, name):
        self.collection.delete_one({"name": name})