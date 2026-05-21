import json
import os

class ProductModel:
    def __init__(self, json_file="products.json"):
        self.json_file = json_file
        self.vat_percentage = 0.15
        self.verify_or_create_catalog()

    def verify_or_create_catalog(self):
        """Creates the JSON file with 5 default items if it does not exist."""
        if not os.path.exists(self.json_file):
            default_items = [
                {"id": 1, "product": "Laptop", "price": 850.00},
                {"id": 2, "product": "Desktop PC", "price": 1200.00},
                {"id": 3, "product": "Optical Mouse", "price": 25.50},
                {"id": 4, "product": "16GB RAM Stick", "price": 65.00},
                {"id": 5, "product": "24-inch Monitor", "price": 180.00}
            ]
            self.save_catalog(default_items)

    def save_catalog(self, product_list):
        with open(self.json_file, 'w', encoding='utf-8') as f:
            json.dump(product_list, f, indent=4, ensure_ascii=False)

    def read_catalog(self):
        """Returns the available products from the JSON file."""
        try:
            with open(self.json_file, 'r', encoding='utf-8') as f:
                return json.load(f)
        except (json.JSONDecodeError, FileNotFoundError):
            return []

    def calculate_item_values(self, base_price):
        """Calculates 15% VAT and the total for a single product."""
        vat = base_price * self.vat_percentage
        total = base_price + vat
        return round(vat, 2), round(total, 2)

    def calculate_list_totals(self, chosen_products):
        """Calculates subtotal, VAT, and grand total for the cart."""
        subtotal = sum(p['price'] for p in chosen_products)
        vat = sum(p['vat'] for p in chosen_products)
        total = sum(p['total'] for p in chosen_products)
        return round(subtotal, 2), round(vat, 2), round(total, 2)