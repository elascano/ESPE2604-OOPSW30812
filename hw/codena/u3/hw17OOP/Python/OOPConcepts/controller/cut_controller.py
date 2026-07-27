from utils.mongo_connection import MongoConnection
from model.cut import Cut


class CutController:

    def __init__(self):

        database = MongoConnection.get_database()

        self.collection = database["cuts"]

    def create(self, cut):

        document = {"description": cut.description , "procedure": cut.procedure, "weight": cut.weight}

        self.collection.insert_one(document)


    def read(self):

        cuts = []

        documents = self.collection.find()

        for document in documents:

            cut = Cut(0,
                document["description"],
                document["procedure"],
                document["weight"]
            )

            cuts.append(cut)

        return cuts
