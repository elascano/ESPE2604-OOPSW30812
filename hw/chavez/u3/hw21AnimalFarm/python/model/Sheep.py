from model.FarmAnimal import FarmAnimal
from model.Product import Product

class Sheep(FarmAnimal):

    def produce(self):
        product = Product("Wool")
        print(f"Sheep produced {product}")