class ChickenFarmer:
    def __init__(self, name):
        self.name = name

    def collect_egg(self, chicken):
        
        print(f"El granjero {self.name} está revisando a {chicken.name} para ver si puso un huevo.")