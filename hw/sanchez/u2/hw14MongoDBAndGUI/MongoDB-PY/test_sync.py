from config.database import connect, get_database
from model import product_management, credit_management

connect()
db = get_database()

print("Connected to database:", db.name)

products_collection = db["products"]
credits_collection = db["credits"]

print("Products in MongoDB:", products_collection.count_documents({}))
print("Credits in MongoDB:", credits_collection.count_documents({}))

print("\nProducts in local JSON:", len(product_management.get_all_products()))
print("Credits in local JSON:", len(credit_management.get_all_accounts()))

print("\n--- UPLOADING LOCAL DATA TO MONGODB ---")

for p in product_management.get_all_products():
    result = products_collection.update_one(
        {"id": p["id"]},
        {"$set": p},
        upsert=True
    )
    print(f"Product {p['id']} - {p['name']}: {'inserted' if result.upserted_id else 'updated'}")

for c in credit_management.get_all_accounts():
    result = credits_collection.update_one(
        {"customerId": c["customerId"]},
        {"$set": c},
        upsert=True
    )
    print(f"Credit {c['customerId']} - {c['customerName']}: {'inserted' if result.upserted_id else 'updated'}")

print("\n--- SYNC COMPLETED ---")