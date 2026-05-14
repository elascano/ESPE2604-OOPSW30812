import csv
import json
from datetime import datetime, date
from typing import List, Dict

class Product:
    def __init__(self, id: str, name: str, expiration_date: str, stock: int, price: float):
        self.id = id
        self.name = name
        self.expiration_date = expiration_date
        self.stock = stock
        self.price = price
        self.discount = 0

    def get_price_with_discount(self) -> float:
        return self.price * (100 - self.discount) / 100

    def calculate_days_until_expiration(self) -> int:
        today = date.today()
        exp_date = datetime.strptime(self.expiration_date, "%Y-%m-%d").date()
        return (exp_date - today).days

    def calculate_and_assign_discount(self):
        days = self.calculate_days_until_expiration()
        if 0 <= days <= 2:
            self.discount = 50
        elif days <= 4:
            self.discount = 25
        elif days <= 7:
            self.discount = 10
        else:
            self.discount = 0

    def show_alert(self):
        days = self.calculate_days_until_expiration()
        print(f"Producto: {self.name}")
        print(f"ID: {self.id}")
        print(f"Stock actual: {self.stock}")
        print(f"Dias hasta caducar: {days}")
        if 0 <= days <= 7:
            print("ALERTA Producto proximo a caducar")
            print(f"Descuento sugerido: {self.discount}%")
            print(f"Precio original: ${self.price:.2f}")
            print(f"Precio con descuento: ${self.get_price_with_discount():.2f}\n")
        elif days < 0:
            print("Producto caducado Retirar del stock inmediatamente\n")
        else:
            print("Producto en buen estado\n")

    @staticmethod
    def read_csv(file_path: str) -> List['Product']:
        products = []
        try:
            with open(file_path, 'r', encoding='utf-8') as f:
                reader = csv.reader(f)
                next(reader)
                for row in reader:
                    id_, name, exp_date, stock, price = row
                    products.append(Product(id_, name, exp_date, int(stock), float(price)))
            print("Archivo CSV leido correctamente")
        except Exception as e:
            print(f"Error al leer el archivo CSV: {e}")
        return products

    @staticmethod
    def get_product_map(products: List['Product']) -> Dict[str, 'Product']:
        return {p.name: p for p in products}

    @staticmethod
    def get_stock_map(products: List['Product']) -> Dict[str, int]:
        return {p.name: p.stock for p in products}

    @staticmethod
    def export_to_json(products: List['Product'], file_path: str):
        data = [{"id": p.id, "name": p.name, "expirationDate": p.expiration_date,
                 "stock": p.stock, "price": p.price, "discount": p.discount} for p in products]
        try:
            with open(file_path, 'w', encoding='utf-8') as f:
                json.dump(data, f, indent=4, ensure_ascii=False)
            print(f"Archivo JSON de productos generado: {file_path}")
        except Exception as e:
            print(f"Error al generar JSON: {e}")