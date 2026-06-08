from pymongo import MongoClient
from pymongo.errors import ConnectionFailure

class BillingController:
    def __init__(self):
        self.db = self._connect_to_database()

    def _connect_to_database(self):
        uri = "mongodb+srv://admin:Espe2026@christopher.i75hlaj.mongodb.net/?retryWrites=true&w=majority"
        try:
            client = MongoClient(uri, serverSelectionTimeoutMS=5000)
            client.admin.command('ping')
            print("Success: Connected to MongoDB Atlas!")
            return client['BillingDB']
        except ConnectionFailure:
            print("Error: Database connection failed.")
            return None

    
    def save_or_update_person(self, person_obj):
        if self.db is None: raise Exception("No connection.")
        self.db['persons'].update_one({"_id": person_obj.person_id}, {"$set": person_obj.to_dict()}, upsert=True)

    def find_person(self, person_id):
        if self.db is None: raise Exception("No connection.")
        return self.db['persons'].find_one({"_id": person_id})

   
    def save_or_update_product(self, product_obj):
        if self.db is None: raise Exception("No connection.")
        self.db['products'].update_one({"_id": product_obj.product_id}, {"$set": product_obj.to_dict()}, upsert=True)

    def find_product(self, product_id):
        if self.db is None: raise Exception("No connection.")
        return self.db['products'].find_one({"_id": product_id})

   
    def save_or_update_payment(self, payment_obj):
        if self.db is None: raise Exception("No connection.")
        self.db['payments'].update_one({"_id": payment_obj.payment_id}, {"$set": payment_obj.to_dict()}, upsert=True)

    def find_payment(self, payment_id):
        if self.db is None: raise Exception("No connection.")
        return self.db['payments'].find_one({"_id": payment_id})