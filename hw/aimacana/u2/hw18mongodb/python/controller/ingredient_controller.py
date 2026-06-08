from typing import List
from controller.database_controller import IDatabaseController
from model.ingredient import Ingredient

class IngredientController(IDatabaseController[Ingredient]):
    def __init__(self, db):
        self.collection = db["ingredients"]

    def create(self, entity: Ingredient) -> None:
        if entity:
            self.collection.insert_one(entity.to_dict())

    def read_all(self) -> List[Ingredient]:
        results = self.collection.find()
        return [Ingredient.from_dict(item) for item in results]

    def read_by_id(self, id_field: str, id_value: str) -> Ingredient:
        item = self.collection.find_one({id_field: id_value})
        return Ingredient.from_dict(item) if item else None

    def update(self, id_field: str, id_value: str, field_name: str, new_value: any) -> None:
        if hasattr(new_value, '__float__') and not isinstance(new_value, (int, str)):
            new_value = float(new_value)
        self.collection.update_one({id_field: id_value}, {"$set": {field_name: new_value}})

    def delete(self, id_field: str, id_value: str) -> None:
        self.collection.delete_one({id_field: id_value})

    def clean_collection(self) -> None:
        self.collection.drop()
