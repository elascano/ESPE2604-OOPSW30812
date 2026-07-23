from mongo_manager import db

class FarmAnimalDAO:

    def save_animal(self, animal):

        document = {
            "id": animal.id,
            "breed": animal.breed,
            "weight": animal.weight,
            "type": animal.__class__.__name__
        }

        db.animals.insert_one(document)

        print("Animal saved successfully.")

    def get_animals(self):

        return list(db.animals.find())