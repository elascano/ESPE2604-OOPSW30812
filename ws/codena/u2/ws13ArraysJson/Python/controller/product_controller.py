import json
import os

from model.product import Product


class ProductController:

    def __init__(self, view):
        self.view = view
        self.products = []
        self.file_path = "data/products.json"

    def add_product(self, name, weight_pounds):

        product = Product(name, weight_pounds)

        self.products.append(product)

    def save_products_to_json(self):

        data = [product.to_dict() for product in self.products]

        with open(self.file_path, "w") as file:
            json.dump(data, file, indent=4)

        self.view.show_message(
            "\nProducts saved successfully."
        )

    def read_products_and_convert(self):

        if not os.path.exists(self.file_path):

            self.view.show_message(
                "\nJSON file not found."
            )

            return

        with open(self.file_path, "r") as file:

            products = json.load(file)

        converted_products = []

        for product in products:

            kilograms = (
                product["weight_pounds"] * 0.453592
            )

            converted_products.append({
                "name": product["name"],
                "weight_kilograms": kilograms
            })

        self.view.show_products(converted_products)