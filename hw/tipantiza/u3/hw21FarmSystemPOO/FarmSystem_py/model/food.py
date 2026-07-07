class Food:
    def __init__(self, id: int, description: str):
        self.id = id
        self.description = description
    
    def __str__(self):
        return f"Food(id={self.id}, description={self.description})"
    
    def get_id(self) -> int:
        return self.id
    
    def set_id(self, id: int):
        self.id = id
    
    def get_description(self) -> str:
        return self.description
    
    def set_description(self, description: str):
        self.description = description