class ChickenFarm:
    def __init__(self, name, chickenCoops = []):
        self.name = name
        self.chickenCoops = chickenCoops

    @property
    def get_name(self):
        return self.name

    @name.setter
    def set_name(self, name):
        self.name = name

    @property
    def get_chickenCoops(self):
        return self.chickenCoops

    @chickenCoops.setter
    def set_chickenCoops(self, chickenCoops):
        self.chickenCoops = chickenCoops

    def __str__(self):
        return f"ChickenFarm(name={self.name}, chickenCoops={self.chickenCoops})"

    def add(self, chickenCoop):
        pass
    def remove(self, chickenCoopId):
        pass
    def resetIteration(self):
        pass
    def next(self):
        pass
