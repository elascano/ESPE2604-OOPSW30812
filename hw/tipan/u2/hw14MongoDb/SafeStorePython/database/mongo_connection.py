from pymongo import MongoClient

client = MongoClient("mongodb+srv://Ronald:Ronald@cluster0.cd2ybxo.mongodb.net/?appName=Cluster0")
db = client["SafeStoreDB"]