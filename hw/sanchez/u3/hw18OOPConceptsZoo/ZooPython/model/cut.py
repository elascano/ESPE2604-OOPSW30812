class Cut:
    def __init__(self, id: int, description: str, procedure: str, weight: float):
        self.id = id
        self.description = description
        self.procedure = procedure
        self.weight = weight
    
    def __str__(self):
        return f"Cut(id={self.id}, description='{self.description}', procedure='{self.procedure}', weight={self.weight})"