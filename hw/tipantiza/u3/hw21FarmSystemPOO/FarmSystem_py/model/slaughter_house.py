class SlaughterHouse:
    def __init__(self, id: int, name: str, address: str, cellphone_number: str):
        self.id = id
        self.name = name
        self.address = address
        self.cellphone_number = cellphone_number
    
    def __str__(self):
        return f"SlaughterHouse(id={self.id}, name={self.name}, address={self.address}, cellphone_number={self.cellphone_number})"
    
    def get_id(self) -> int:
        return self.id
    
    def set_id(self, id: int):
        self.id = id
    
    def get_name(self) -> str:
        return self.name
    
    def set_name(self, name: str):
        self.name = name
    
    def get_address(self) -> str:
        return self.address
    
    def set_address(self, address: str):
        self.address = address
    
    def get_cellphone_number(self) -> str:
        return self.cellphone_number
    
    def set_cellphone_number(self, cellphone_number: str):
        self.cellphone_number = cellphone_number