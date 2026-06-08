from config.database import get_database, PRODUCTS_COLLECTION, CREDITS_COLLECTION
from model import product_management, credit_management

def get_all_products_from_cloud():
    db = get_database()
    if not db:
        return []
    try:
        collection = db[PRODUCTS_COLLECTION]
        return list(collection.find({}, {"_id": 0}))
    except Exception as e:
        print(f"Error getting products: {e}")
        return []

def get_all_credits_from_cloud():
    db = get_database()
    if not db:
        return []
    try:
        collection = db[CREDITS_COLLECTION]
        return list(collection.find({}, {"_id": 0}))
    except Exception as e:
        print(f"Error getting credits: {e}")
        return []

def sync_from_cloud_to_local():
    print("Downloading from cloud...")
    cloud_products = get_all_products_from_cloud()
    print(f"Products found in cloud: {len(cloud_products)}")
    
    for doc in cloud_products:
        existing = product_management.find_by_id(doc["id"])
        if not existing:
            product_management.products.append(doc)
            print(f"New product: {doc['name']}")
        else:
            existing.update(doc)
            print(f"Updated product: {doc['name']}")
    product_management.save_to_file()
    
    cloud_credits = get_all_credits_from_cloud()
    print(f"Credits found in cloud: {len(cloud_credits)}")
    
    for doc in cloud_credits:
        existing = credit_management.find_account_by_id(doc["customerId"])
        if not existing:
            credit_management.accounts.append(doc)
            print(f"New credit: {doc['customerName']}")
        else:
            existing.update(doc)
            print(f"Updated credit: {doc['customerName']}")
    credit_management.save_to_file()
    
    print("Sync completed: CLOUD -> LOCAL")

def sync_from_local_to_cloud():
    db = get_database()
    if not db:
        print("No connection to MongoDB")
        return
    
    print("Uploading to cloud...")
    products_collection = db[PRODUCTS_COLLECTION]
    local_products = product_management.get_all_products()
    print(f"Local products to upload: {len(local_products)}")
    
    for p in local_products:
        result = products_collection.update_one(
            {"id": p["id"]},
            {"$set": p},
            upsert=True
        )
        print(f"Uploaded product: {p['name']}")
    
    credits_collection = db[CREDITS_COLLECTION]
    local_credits = credit_management.get_all_accounts()
    print(f"Local credits to upload: {len(local_credits)}")
    
    for c in local_credits:
        result = credits_collection.update_one(
            {"customerId": c["customerId"]},
            {"$set": c},
            upsert=True
        )
        print(f"Uploaded credit: {c['customerName']}")
    
    print("Sync completed: LOCAL -> CLOUD")