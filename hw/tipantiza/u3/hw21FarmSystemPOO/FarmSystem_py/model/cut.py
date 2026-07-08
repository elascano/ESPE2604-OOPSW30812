class Cut:
    def __init__(self, id: int, description: str, procedure: str, weight: float):
        self.id = id
        self.description = description
        self.procedure = procedure
        self.weight = weight
    
    def __str__(self):
        return f"Cut(id={self.id}, description={self.description}, procedure={self.procedure}, weight={self.weight})"
    
    def get_id(self) -> int:
        return self.id
    
    def set_id(self, id: int):
        self.id = id
    
    def get_description(self) -> str:
        return self.description
    
    def set_description(self, description: str):
        self.description = description
    
    def get_procedure(self) -> str:
        return self.procedure
    
    def set_procedure(self, procedure: str):
        self.procedure = procedure
    
    def get_weight(self) -> float:
        return self.weight
    
    def set_weight(self, weight: float):
        self.weight = weight