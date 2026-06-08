from pymongo import MongoClient

CONNECTION_STRING = "mongodb+srv://Joel:Joel@cluster0.aex8od4.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
DATABASE_NAME = "safestore_db"
PRODUCTS_COLLECTION = "products"
CREDITS_COLLECTION = "credits"

client = None
database = None

def connect():
    global client, database
    try:
        client = MongoClient(CONNECTION_STRING)
        database = client[DATABASE_NAME]
        print("Connected to MongoDB Atlas")
        return database
    except Exception as e:
        print(f"Error connecting to MongoDB: {e}")
        return None

def get_database():
    global database
    if database is None:
        connect()
    return database

def close():
    global client
    if client:
        client.close()
        print("Disconnected from MongoDB")