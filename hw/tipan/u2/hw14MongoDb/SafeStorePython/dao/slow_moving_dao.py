from database.mongo_connection import db

collection = db["slowMoving"]

def save_slow_moving(item):
    collection.insert_one({
        "product": item.product,
        "stock": item.stock,
        "sales": item.sales,
        "status": item.status
    })