import sys
import os

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from utils.tax import Tax

class Product:
    def __init__(self, id: int, description: str, price: float, pvp: float = None):
        self.id = id
        self.description = description
        self.price = price
        
        if pvp is None:
            
            self.pvp = Tax.compute_total(price, 15.0)
        else:
            self.pvp = pvp

    def get_id(self) -> int: return self.id
    def get_description(self) -> str: return self.description
    def get_price(self) -> float: return self.price
    def get_pvp(self) -> float: return self.pvp

    def __str__(self) -> str:
        return f"Product{{id={self.id}, description={self.description}, price={self.price}, pvp={self.pvp}}}"