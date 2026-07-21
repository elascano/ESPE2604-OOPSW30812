from model.FarmAnimal import FarmAnimal
from model.Product import Product

class Chicken(FarmAnimal):

    def produce(self):
        product = Product("Eggs")
        print(f"Chicken produced {product}")