from pymongo import MongoClient
import os


MONGO_URI = "mongodb+srv://Adrian:Adrian@cluster0.e4n4vbs.mongodb.net/?appName=Cluster0"

client = MongoClient(MONGO_URI)

db = client.strategyVizcaino

collection = db.arrayAdrian

def save_result(original, size, algorithm, result):

    document = {
        "unsorted": original,
        "size": size,
        "sort_algorithm": algorithm,
        "sorted": result
    }

    collection.insert_one(document)

