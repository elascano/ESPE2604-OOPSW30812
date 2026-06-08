from database.mongo_connection import MongoConnection

class ReservationDAO:

    def __init__(self):
        db = MongoConnection.get_database()
        self.collection = db["reservations"]

    def save(self, reservation):

        self.collection.insert_one({
            "id": reservation.id,
            "customerName": reservation.customer_name,
            "phone": reservation.phone,
            "status": reservation.status
        })

    def find_all(self):

        return list(self.collection.find({}, {"_id": 0}))

    def delete(self, id):

        self.collection.delete_one({"id": id})