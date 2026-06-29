from datetime import datetime
from typing import List, Optional
from pymongo.collection import Collection
from model.farm_animal import FarmAnimal
from model.cow import Cow
from model.chicken import Chicken
from model.pig import Pig
from model.sheep import Sheep
from controller.database_connection import DatabaseConnection

class AnimalController:
    def __init__(self):
        self.db = DatabaseConnection()
        self.date_format = "%Y-%m-%d"
    
    def register_animal(self, animal: FarmAnimal) -> bool:
        try:
            collection: Collection = self.db.get_collection("animals")
            doc = {
                "id": animal.id,
                "type": animal.__class__.__name__,
                "breed": animal.breed,
                "bornOn": animal.born_on,
                "weight": animal.weight,
                "registeredAt": datetime.now()
            }
            
            if isinstance(animal, Cow):
                doc["isProducingMilk"] = animal.is_producing_milk
                doc["milkProduced"] = animal.milk_produced
            elif isinstance(animal, Chicken):
                doc["isMolting"] = animal.is_molting
                doc["numberOfEggsPerWeek"] = animal.number_of_eggs_per_week
            elif isinstance(animal, Pig):
                doc["idealWeight"] = animal.ideal_weight
                doc["isReadyForSlaughter"] = animal.is_ready_for_slaughter()
            elif isinstance(animal, Sheep):
                doc["lastSheering"] = animal.last_sheering
            
            collection.insert_one(doc)
            return True
        except Exception as e:
            print(f"Error registering animal: {e}")
            return False
    
    def get_animals_by_type(self, type_name: str) -> List[FarmAnimal]:
        animals = []
        try:
            collection: Collection = self.db.get_collection("animals")
            for doc in collection.find({"type": type_name}):
                animal = self._document_to_animal(doc)
                if animal:
                    animals.append(animal)
        except Exception as e:
            print(f"Error getting animals by type: {e}")
        return animals
    
    def get_all_animals(self) -> List[FarmAnimal]:
        animals = []
        try:
            collection: Collection = self.db.get_collection("animals")
            for doc in collection.find().sort("id", 1):
                animal = self._document_to_animal(doc)
                if animal:
                    animals.append(animal)
        except Exception as e:
            print(f"Error getting all animals: {e}")
        return animals
    
    def get_animal_by_id(self, id: int) -> Optional[FarmAnimal]:
        try:
            collection: Collection = self.db.get_collection("animals")
            doc = collection.find_one({"id": id})
            if doc:
                return self._document_to_animal(doc)
            return None
        except Exception as e:
            print(f"Error searching animal by ID: {e}")
            return None
    
    def delete_animal(self, id: int) -> bool:
        try:
            collection: Collection = self.db.get_collection("animals")
            result = collection.delete_one({"id": id})
            return result.deleted_count > 0
        except Exception as e:
            print(f"Error deleting animal: {e}")
            return False
    
    def calculate_total_milk_production(self) -> float:
        total_milk = 0.0
        try:
            cows = self.get_animals_by_type("Cow")
            for animal in cows:
                if isinstance(animal, Cow):
                    total_milk += animal.milk_produced
        except Exception as e:
            print(f"Error calculating milk production: {e}")
        return total_milk
    
    def calculate_total_eggs_per_week(self) -> int:
        total_eggs = 0
        try:
            chickens = self.get_animals_by_type("Chicken")
            for animal in chickens:
                if isinstance(animal, Chicken):
                    total_eggs += animal.number_of_eggs_per_week
        except Exception as e:
            print(f"Error calculating total eggs: {e}")
        return total_eggs
    
    def get_pigs_ready_for_slaughter(self) -> List[Pig]:
        ready_pigs = []
        try:
            pigs = self.get_animals_by_type("Pig")
            for animal in pigs:
                if isinstance(animal, Pig) and animal.is_ready_for_slaughter():
                    ready_pigs.append(animal)
        except Exception as e:
            print(f"Error getting ready pigs: {e}")
        return ready_pigs
    
    def get_zoo_statistics(self) -> str:
        stats = []
        try:
            all_animals = self.get_all_animals()
            total_cows = 0
            total_chickens = 0
            total_pigs = 0
            total_sheep = 0
            total_weight = 0.0
            
            for animal in all_animals:
                total_weight += animal.weight
                if isinstance(animal, Cow):
                    total_cows += 1
                elif isinstance(animal, Chicken):
                    total_chickens += 1
                elif isinstance(animal, Pig):
                    total_pigs += 1
                elif isinstance(animal, Sheep):
                    total_sheep += 1
            
            stats.append("=== ZOO STATISTICS ===")
            stats.append(f"Total animals: {len(all_animals)}")
            stats.append(f"├─ Cows: {total_cows}")
            stats.append(f"├─ Chickens: {total_chickens}")
            stats.append(f"├─ Pigs: {total_pigs}")
            stats.append(f"└─ Sheep: {total_sheep}")
            stats.append(f"Total weight: {total_weight:.2f} kg")
            avg_weight = 0 if len(all_animals) == 0 else total_weight / len(all_animals)
            stats.append(f"Average weight: {avg_weight:.2f} kg")
            
        except Exception as e:
            print(f"Error getting statistics: {e}")
            stats.append("Error generating statistics")
        return "\n".join(stats)
    
    def _parse_date(self, date_obj):
        if date_obj is None:
            return datetime.now()
        if isinstance(date_obj, datetime):
            return date_obj
        if isinstance(date_obj, str):
            try:
                return datetime.strptime(date_obj, "%Y-%m-%dT%H:%M:%S.%fZ")
            except ValueError:
                try:
                    return datetime.strptime(date_obj, "%Y-%m-%dT%H:%M:%SZ")
                except ValueError:
                    try:
                        return datetime.strptime(date_obj, "%Y-%m-%d")
                    except ValueError:
                        return datetime.now()
        return datetime.now()
    
    def _get_float(self, obj):
        if obj is None:
            return 0.0
        if isinstance(obj, (int, float)):
            return float(obj)
        if isinstance(obj, str):
            try:
                return float(obj)
            except ValueError:
                return 0.0
        return 0.0
    
    def _get_int(self, obj):
        if obj is None:
            return 0
        if isinstance(obj, int):
            return obj
        if isinstance(obj, float):
            return int(obj)
        if isinstance(obj, str):
            try:
                return int(obj)
            except ValueError:
                return 0
        return 0
    
    def _document_to_animal(self, doc) -> Optional[FarmAnimal]:
        try:
            animal_type = doc.get("type")
            id = doc.get("id")
            breed = doc.get("breed")
            born_on = self._parse_date(doc.get("bornOn"))
            weight = self._get_float(doc.get("weight"))
            
            if animal_type == "Cow":
                is_producing_milk = doc.get("isProducingMilk", False)
                cow = Cow(id, breed, born_on, weight, is_producing_milk)
                return cow
            elif animal_type == "Chicken":
                is_molting = doc.get("isMolting", False)
                eggs = self._get_int(doc.get("numberOfEggsPerWeek"))
                chicken = Chicken(id, breed, born_on, weight, is_molting)
                chicken.number_of_eggs_per_week = eggs
                return chicken
            elif animal_type == "Pig":
                ideal_weight = self._get_float(doc.get("idealWeight"))
                pig = Pig(id, breed, born_on, weight, ideal_weight)
                return pig
            elif animal_type == "Sheep":
                last_sheering = self._parse_date(doc.get("lastSheering"))
                sheep = Sheep(id, breed, born_on, weight, last_sheering)
                return sheep
            return None
        except Exception as e:
            print(f"Error converting document to animal: {e}")
            return None