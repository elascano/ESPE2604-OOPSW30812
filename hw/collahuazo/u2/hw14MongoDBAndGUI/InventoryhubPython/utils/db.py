from pymongo import MongoClient


URI = "mongodb+srv://brandon:1752221067@cluster0.evr08tq.mongodb.net/?appName=Cluster0"
DATABASE_NAME = "inventoryHub"


def get_database():
    client = MongoClient(URI)
    return client[DATABASE_NAME]
