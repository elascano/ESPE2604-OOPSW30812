import csv
import json
from typing import List, Dict
from model.product import Product

class PromotionalBundle:
    def __init__(self, bundle_id: str, name: str, product1: str, quantity1: int,
                 product2: str, quantity2: int, product3: str, quantity3: int, bundle_price: float):
        self.bundle_id = bundle_id
        self.name = name
        self.product1 = product1
        self.quantity1 = quantity1
        self.product2 = product2
        self.quantity2 = quantity2
        self.product3 = product3
        self.quantity3 = quantity3
        self.bundle_price = bundle_price
        self.profit_margin = 0.0

    @staticmethod
    def read_csv(file_path: str) -> List['PromotionalBundle']:
        bundles = []
        try:
            with open(file_path, 'r', encoding='utf-8') as f:
                reader = csv.reader(f)
                next(reader)
                for row in reader:
                    bundles.append(PromotionalBundle(
                        row[0], row[1], row[2], int(row[3]), row[4], int(row[5]), row[6], int(row[7]), float(row[8])
                    ))
            print("Archivo de paquetes leido correctamente")
        except Exception as e:
            print(f"Error al leer paquetes: {e}")
        return bundles

    def calculate_cost_price(self, product_map: Dict[str, Product]) -> float:
        total_cost = 0.0
        total_cost += self._get_product_cost(self.product1, self.quantity1, product_map)
        total_cost += self._get_product_cost(self.product2, self.quantity2, product_map)
        total_cost += self._get_product_cost(self.product3, self.quantity3, product_map)
        return total_cost

    def _get_product_cost(self, product_name: str, quantity: int, product_map: Dict[str, Product]) -> float:
        if not product_name or product_name == "0" or quantity == 0:
            return 0.0
        if product_name in product_map:
            return product_map[product_name].price * quantity
        return 0.0

    def calculate_profit_margin(self, product_map: Dict[str, Product]):
        total_cost = self.calculate_cost_price(product_map)
        if self.bundle_price > 0:
            self.profit_margin = ((self.bundle_price - total_cost) / self.bundle_price) * 100

    def has_positive_profit(self) -> bool:
        return self.profit_margin > 0

    def has_enough_stock(self, stock_map: Dict[str, int]) -> bool:
        checks = [(self.product1, self.quantity1), (self.product2, self.quantity2), (self.product3, self.quantity3)]
        for product, qty in checks:
            if product and product != "0" and qty > 0:
                if product not in stock_map or stock_map[product] < qty:
                    return False
        return True

    @staticmethod
    def export_to_json(bundles: List['PromotionalBundle'], file_path: str):
        data = [{"bundleId": b.bundle_id, "name": b.name, "product1": b.product1,
                 "quantity1": b.quantity1, "product2": b.product2, "quantity2": b.quantity2,
                 "product3": b.product3, "quantity3": b.quantity3, "bundlePrice": b.bundle_price,
                 "profitMargin": b.profit_margin} for b in bundles]
        try:
            with open(file_path, 'w', encoding='utf-8') as f:
                json.dump(data, f, indent=4, ensure_ascii=False)
            print(f"Archivo JSON de paquetes generado: {file_path}")
        except Exception as e:
            print(f"Error al generar JSON: {e}")