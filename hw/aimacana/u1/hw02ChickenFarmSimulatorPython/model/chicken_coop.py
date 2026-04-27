class ChickenCoop:
    def __init__(self, id, chickens = []):
        self.id = id
        self.chickens = chickens

    @property
    def get_id(self):
        return self.id
    @id.setter
    def set_id(self, id):
        self.id = id

    @property
    def get_chickens(self):
        return self.chickens

    @chickens.setter
    def set_chickens(self, chickens):
        self.chickens = chickens
        
    def __str__(self):
        return f"ChickenCoop(id={self.id}, chickens={self.chickens})"
