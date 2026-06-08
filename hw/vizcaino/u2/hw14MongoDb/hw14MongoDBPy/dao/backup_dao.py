from database.mongo_connection import MongoConnection

class BackupDAO:

    def __init__(self):
        db = MongoConnection.get_database()
        self.collection = db["backups"]

    def save(self, backup):

        self.collection.insert_one({
            "id": backup.id,
            "fileName": backup.file_name,
            "status": backup.status,
            "date": backup.date
        })

    def find_all(self):

        return list(self.collection.find({}, {"_id": 0}))

    def delete(self, id):

        self.collection.delete_one({"id": id})