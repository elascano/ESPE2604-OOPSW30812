import os
import json

class Package:
    def __init__(self, item_id, name, weight):
        self.item_id, self.name, self.weight = item_id, name, weight
    
    def to_dict(self):
        return vars(self) 

class Truck:
    def __init__(self, truck_id, model, max_capacity, owner):
        self.truck_id, self.model = truck_id, model
        self.max_capacity, self.owner = max_capacity, owner
        self.inventory = []

    def add_package(self, pkg):
        self.inventory.append(pkg)

    def save_json(self, name="data.json"):
        data = vars(self).copy()
        data['inventory'] = [p.to_dict() for p in self.inventory]
        with open(name, "w") as f: json.dump(data, f, indent=4)

    @staticmethod
    def read_json(name="data.json"):
        if os.path.exists(name):
            with open(name, "r") as f: return json.load(f)
        return None