import csv
import json
import os


class FileManager:

    # ===== CSV =====
    @staticmethod
    def save_product_csv(p):
        with open("products.csv", "a", newline="") as f:
            csv.writer(f).writerow([p.id, p.name, p.stock, p.price])

    @staticmethod
    def save_customer_csv(c):
        with open("customers.csv", "a", newline="") as f:
            csv.writer(f).writerow([c.id, c.name, c.category])

    @staticmethod
    def save_supplier_csv(s):
        with open("suppliers.csv", "a", newline="") as f:
            csv.writer(f).writerow([s.id, s.name, s.email])

    # ===== JSON =====
    @staticmethod
    def _save_json(file, obj):
        data = []

        if os.path.exists(file):
            try:
                data = json.load(open(file))
            except:
                data = []

        data.append(obj.__dict__)

        json.dump(data, open(file, "w"), indent=4)

    @staticmethod
    def save_product_json(p):
        FileManager._save_json("products.json", p)

    @staticmethod
    def save_customer_json(c):
        FileManager._save_json("customers.json", c)

    @staticmethod
    def save_supplier_json(s):
        FileManager._save_json("suppliers.json", s)