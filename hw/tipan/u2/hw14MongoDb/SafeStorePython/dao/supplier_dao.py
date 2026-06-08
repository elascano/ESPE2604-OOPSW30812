from database.mongo_connection import db

collection = db["suppliers"]

def save_supplier(supplier):
    collection.insert_one({
        "id": supplier.id,
        "name": supplier.name,
        "phone": supplier.phone,
        "email": supplier.email
    })