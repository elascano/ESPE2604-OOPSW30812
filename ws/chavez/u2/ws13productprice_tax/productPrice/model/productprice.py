import json
import os

import json
import os

FILE_NAME = "productJSON.json"


class ProductPrice:

    def load_products(self):
        if os.path.exists(FILE_NAME):
            with open(FILE_NAME, 'r', encoding='utf-8') as file:
                try:
                    return json.load(file)
                except json.JSONDecodeError:
                    return []
        return []

    def save_products(self, products):
        with open(FILE_NAME, 'w', encoding='utf-8') as file:
            json.dump(products, file, indent=4)

    def add_product(self, name, price):

        tax = price * 0.15

        products = self.load_products()

        product = {
            "name": name,
            "price": price,
            "tax": tax
        }

        products.append(product)
        self.save_products(products)

    def get_total_tax(self):
        products = self.load_products()
        return sum(product.get("tax", 0) for product in products)