import json
import os

FILE_NAME = "products.json"
products = []

def load_from_file():
    global products
    try:
        if os.path.exists(FILE_NAME):
            with open(FILE_NAME, 'r', encoding='utf-8') as f:
                products = json.load(f)
        else:
            products = []
    except Exception as e:
        print(f"Error loading products: {e}")
        products = []

def save_to_file():
    try:
        with open(FILE_NAME, 'w', encoding='utf-8') as f:
            json.dump(products, f, indent=2, ensure_ascii=False)
    except Exception as e:
        print(f"Error saving products: {e}")

def get_all_products():
    return [p.copy() for p in products]

def add_product(product):
    products.append(product)
    save_to_file()

def delete_product(id):
    global products
    products = [p for p in products if p["id"] != id]
    save_to_file()

def find_by_id(id):
    for p in products:
        if p["id"] == id:
            return p
    return None

load_from_file()