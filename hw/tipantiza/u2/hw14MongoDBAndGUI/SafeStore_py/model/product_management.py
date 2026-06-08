"""
Product Management Module
@author Alexander Tipantiza, The Softwarriors, @ESPE
"""

from typing import List, Optional

class Product:
    """Product class"""
    
    def __init__(self, product_id: int, name: str, stock: int, 
                 retail_price: float, wholesale_price: float):
        self.id = product_id
        self.name = name
        self.stock = stock
        self.retail_price = retail_price
        self.wholesale_price = wholesale_price
    
    def get_id(self) -> int:
        return self.id
    
    def get_name(self) -> str:
        return self.name
    
    def get_stock(self) -> int:
        return self.stock
    
    def get_retail_price(self) -> float:
        return self.retail_price
    
    def get_wholesale_price(self) -> float:
        return self.wholesale_price
    
    def set_stock(self, stock: int):
        self.stock = stock
    
    def __repr__(self):
        return f"Product(id={self.id}, name={self.name}, stock={self.stock})"


class ProductManagement:
    """Product management class"""
    
    _products: List[Product] = []
    
    @classmethod
    def _init_sample_products(cls):
        """Initialize with sample products"""
        if not cls._products:
            cls._products = [
                Product(1, "Laptop", 50, 800.00, 750.00),
                Product(2, "Mouse", 100, 25.00, 20.00),
                Product(3, "Keyboard", 75, 45.00, 38.00),
                Product(4, "Monitor", 30, 200.00, 180.00),
                Product(5, "Printer", 5, 150.00, 130.00),
            ]
    
    @classmethod
    def find_by_id(cls, product_id: int) -> Optional[Product]:
        """Find product by ID"""
        cls._init_sample_products()
        for p in cls._products:
            if p.get_id() == product_id:
                return p
        return None
    
    @classmethod
    def update_product_stock(cls, product_id: int, new_stock: int):
        """Update product stock"""
        product = cls.find_by_id(product_id)
        if product:
            product.set_stock(new_stock)
    
    @classmethod
    def get_all_products(cls) -> List[Product]:
        """Get all products"""
        cls._init_sample_products()
        return cls._products.copy()