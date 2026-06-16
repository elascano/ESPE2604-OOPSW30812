from pymongo import MongoClient

class KeyboardController:

    def __init__(self):

        uri = "mongodb+srv://Ronald:Ronald@cluster0.cd2ybxo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"

        client = MongoClient(uri)

        db = client["KeyboardDB"]

        self.collection = db["keyboards"]

    def create(self, keyboard):

        document = {
            "id": keyboard.id,
            "name": keyboard.name,
            "price": keyboard.price,
            "key_count": keyboard.key_count,
            "business_value": keyboard.calculate_value()
        }

        self.collection.insert_one(document)