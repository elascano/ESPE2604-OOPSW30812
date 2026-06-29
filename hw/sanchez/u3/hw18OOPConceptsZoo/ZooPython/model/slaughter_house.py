class SlaughterHouse:
    def __init__(self, id: int, name: str, location: str):
        self.id = id
        self.name = name
        self.location = location
    
    def __str__(self):
        return f"SlaughterHouse(id={self.id}, name='{self.name}', location='{self.location}')"