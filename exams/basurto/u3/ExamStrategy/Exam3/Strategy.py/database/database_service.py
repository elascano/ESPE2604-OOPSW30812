from pymongo import MongoClient

class DatabaseService:
    def __init__(self):
        # TODO: Replace with your actual MongoDB Atlas connection URI
        self.uri = "mongodb+srv://<username>:<password>@cluster.mongodb.net/?retryWrites=true&w=majority"
        self.db_name = "strategyLastName"        # Replace with your actual Last Name
        self.collection_name = "arrayFirstName"  # Replace with your actual First Name

    def save_result(self, unsorted_str: str, size: int, algorithm_name: str, sorted_str: str):
        try:
            client = MongoClient(self.uri, serverSelectionTimeoutMS=3000)
            db = client[self.db_name]
            collection = db[self.collection_name]

            document = {
                "unsorted": unsorted_str,
                "size": size,
                "algorithm": algorithm_name,
                "sorted": sorted_str
            }

            collection.insert_one(document)
            client.close()
            return True, "Successfully saved to MongoDB Atlas."
        except Exception as e:
            return False, f"Failed to save to database: {str(e)}"