"""
@author: Collahuazo Brandon, CodeBros, @ESPE
"""
import sys
import os


PRODUCT_DIR = os.path.dirname(__file__)
TAX_LIB_ROOT = os.path.abspath(os.path.join(PRODUCT_DIR, '../../../TaxLib'))
sys.path.append(TAX_LIB_ROOT)


from utils.tax import Tax  # type: ignore

class Product:
   
    def __init__(self, id, descripcion, price, pvp=None):
        self.id = id
        self.descripcion = descripcion
        self.price = price
        
        # TODO compute total price
        if pvp is None:
            self.pvp = Tax.computeTotal(price, 15)
        else:
            self.pvp = pvp

    def __str__(self):
        return f"Product\n{{id={self.id} descripcion={self.descripcion} price={self.price} pvp={self.pvp}}}"