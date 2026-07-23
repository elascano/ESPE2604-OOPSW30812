from pymongo import MongoClient

client = MongoClient("mongodb+srv://Ronald:Ronald@cluster0.cd2ybxo.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")

db = client["FarmDB"]