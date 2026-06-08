import json
import os

class Loudspeaker:
    def __init__(self, id, brand, model, wattage):
        self.id = id
        self.brand = brand
        self.model = model
        self.wattage = wattage
    
    def to_dict(self):
        return {
            "id": self.id,
            "brand": self.brand,
            "model": self.model,
            "wattage": self.wattage
        }

def save_to_json(speakers, filename):
    data = [s.to_dict() for s in speakers]
    with open(filename, 'w') as file:
        json.dump(data, file, indent=4)

def load_from_json(filename):
    if not os.path.exists(filename):
        return []
    with open(filename, 'r') as file:
        return json.load(file)

def main():
    data_file = "loudspeakers.json"
    
    inventory = [
        Loudspeaker(1, "JBL", "Flip 6", 26),
        Loudspeaker(2, "Samsung", "SoundLink", 50),
        Loudspeaker(3, "Sony", "SRS-XG300", 120)
    ]
    
    save_to_json(inventory, data_file)
    
    records = load_from_json(data_file)
    
    for item in records:
        print(f"ID: {item['id']} - {item['brand']} {item['model']} ({item['wattage']}W)")

if __name__ == "__main__":
    main()
