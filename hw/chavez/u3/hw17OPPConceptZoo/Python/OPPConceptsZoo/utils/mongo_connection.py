from pymongo import MongoClient


class MongoConnection:

    URI = "mongodb+srv://usuario:contraseña@cluster0.mongodb.net/"

    client = MongoClient(URI)

    database = client["FarmDB"]