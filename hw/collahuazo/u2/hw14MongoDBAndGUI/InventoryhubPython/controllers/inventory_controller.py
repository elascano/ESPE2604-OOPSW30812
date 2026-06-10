from typing import List

from models import Customer, Product, Supplier
from utils import get_database


def insert_customer(customer: Customer) -> None:
    db = get_database()
    db.customers.insert_one(customer.to_dict())


def insert_product(product: Product) -> None:
    db = get_database()
    db.products.insert_one(product.to_dict())


def insert_supplier(supplier: Supplier) -> None:
    db = get_database()
    db.suppliers.insert_one(supplier.to_dict())


def get_all_customers() -> List[dict]:
    db = get_database()
    return list(db.customers.find())


def get_all_products() -> List[dict]:
    db = get_database()
    return list(db.products.find())


def get_all_suppliers() -> List[dict]:
    db = get_database()
    return list(db.suppliers.find())
