import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from libraries.Tax import Tax

class Product:
    
    def __init__(self, id, description, price, pvp=None):
        self._id = id
        self._description = description
        self._price = price
        
        if pvp is None:
            self._pvp = Tax.computeTotal(price, 15.0)
        else:
            self._pvp = pvp

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, id):
        self._id = id

    @property
    def description(self):
        return self._description

    @description.setter
    def description(self, description):
        self._description = description

    @property
    def price(self):
        return self._price

    @price.setter
    def price(self, price):
        self._price = price

    @property
    def pvp(self):
        return self._pvp

    @pvp.setter
    def pvp(self, pvp):
        self._pvp = pvp

    def __str__(self):
        return f"Product\n{{id={self._id}, description={self._description}, price={self._price}, pvp={self._pvp}}}"