from pymongo import MongoClient

class Database:

    def __init__(self):
        self.client = MongoClient("URI")
        self.db = self.client["SchoolSystem"]

        self.students = self.db["students"]
        self.teachers = self.db["teachers"]
        self.courses = self.db["courses"]