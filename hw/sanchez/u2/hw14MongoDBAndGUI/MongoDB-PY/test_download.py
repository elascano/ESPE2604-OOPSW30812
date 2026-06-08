from config.database import connect, get_database
from model import product_management, credit_management

connect()
db = get_database()

print("Downloading products from MongoDB...")
products_collection = db["products"]
cloud_products = list(products_collection.find({}, {"_id": 0}))

print(f"Products found in MongoDB: {len(cloud_products)}")

for doc in cloud_products:
    existing = product_management.find_by_id(doc["id"])
    if not existing:
        product_management.products.append(doc)
    else:
        existing.update(doc)
    product_management.save_to_file()
    print(f"Saved product: {doc['id']} - {doc['name']}")

print("\nDownloading credits from MongoDB...")
credits_collection = db["credits"]
cloud_credits = list(credits_collection.find({}, {"_id": 0}))

print(f"Credits found in MongoDB: {len(cloud_credits)}")

for doc in cloud_credits:
    existing = credit_management.find_account_by_id(doc["customerId"])
    if not existing:
        credit_management.accounts.append(doc)
    else:
        existing.update(doc)
    credit_management.save_to_file()
    print(f"Saved credit: {doc['customerId']} - {doc['customerName']}")

print("\n--- DOWNLOAD COMPLETED ---")
print("Local products:", len(product_management.get_all_products()))
print("Local credits:", len(credit_management.get_all_accounts()))