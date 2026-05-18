import json
from model import Product

class ProductService:
    def __init__(self):
        self.catalog = []        
        self.cart = []           
        self.load_catalog()

    def load_catalog(self):
        """Loads the store menu from the JSON file"""
        try:
            with open("products.json", "r") as file:
                data = json.load(file)
                for item in data:
                    self.catalog.append(Product(item["name"], item["price"]))
        except FileNotFoundError:
            print("Error! The file products.json was not found.")

    def get_catalog(self):
        return self.catalog

    def get_cart(self):
        return self.cart

    def add_to_cart(self, index):
        if 0 <= index < len(self.catalog):
            chosen_product = self.catalog[index]
            self.cart.append(chosen_product)
            return True
        return False

    def calculate_total(self):
        total = 0.0
        for prod in self.cart:
            total += prod.price
        return total