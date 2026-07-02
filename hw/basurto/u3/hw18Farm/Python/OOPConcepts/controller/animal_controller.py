from utils.mongo_connection import MongoConnection
from model.pig import Pig
from model.farm_animal import FarmAnimal
from model.cow import Cow
from model.chicken import Chicken
from model.sheep import Sheep


class AnimalController:

    def __init__(self):

        db = MongoConnection.get_database()

        self.collection = db["animals"]

    def create(self,animal):

        if self.exists(animal.id):
            return False

        self.collection.insert_one(animal.to_document())

        return True
    
    def read(self):

        animals=[]

        for document in self.collection.find():

            animals.append(self.document_to_animal(document))

        return animals
    
    def delete(self,id):

        result=self.collection.delete_one({"_id":id})

        return result.deleted_count>0
    
    def update(self,animal):

        result=self.collection.replace_one({"_id":animal.id},
            animal.to_document()
        )

        return result.modified_count>0
    
    def find_by_id(self,id):

        document=self.collection.find_one({"_id":id})

        if document is None:
            return None

        return self.document_to_animal(document)
    

    def document_to_animal(self,document):


        id = document["_id"]
        type = document["type"]
        breed = document["breed"]
        born_on_date = document["bornOnDate"]
        weight = document["weight"]

        if type == "Chicken":

            return Chicken(
                id,
                breed,
                born_on_date,
                weight,
                document["isMolting"],
                document["numberOfEggs"]
            )

        elif type == "Pig":

            return Pig(
                id,
                breed,
                born_on_date,
                weight,
                document["idealWeight"]
            )

        elif type == "Cow":

            return Cow(
                id,
                breed,
                born_on_date,
                weight,
                document["isProducingMilk"]
            )

        elif type == "Sheep":

            return Sheep(
                id,
                breed,
                born_on_date,
                weight,
                document["lastShearing"]
            )
        
    def exists(self,id):

        document=self.collection.find_one({"_id":id})

        return document is not None