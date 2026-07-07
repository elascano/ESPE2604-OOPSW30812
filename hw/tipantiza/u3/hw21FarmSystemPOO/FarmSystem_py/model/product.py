class Product:
    def __init__(self, id: int, description: str, unit: str, quantity: float):
        self.id = id
        self.description = description
        self.unit = unit
        self.quantity = quantity
    
    def __str__(self):
        return f"Product(id={self.id}, description={self.description}, unit={self.unit}, quantity={self.quantity})"
    
    def get_id(self) -> int:
        return self.id
    
    def set_id(self, id: int):
        self.id = id
    
    def get_description(self) -> str:
        return self.description
    
    def set_description(self, description: str):
        self.description = description
    
    def get_unit(self) -> str:
        return self.unit
    
    def set_unit(self, unit: str):
        self.unit = unit
    
    def get_quantity(self) -> float:
        return self.quantity
    
    def set_quantity(self, quantity: float):
        self.quantity = quantity