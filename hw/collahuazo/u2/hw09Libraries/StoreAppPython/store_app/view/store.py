"""
@author: Collahuazo Brandon, CodeBros, @ESPE
"""
import sys
import os

BASE_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), '../..'))

sys.path.append(os.path.join(BASE_DIR, 'store_app'))
sys.path.append(os.path.join(BASE_DIR, 'TaxLib'))


from model.product import Product
from utils.tax import Tax  # type: ignore

def main():

    id = 1
    descripcion = "compute"
    price = 100.0
    
    pvp = Tax.computeTotal(price, 15)
    product = Product(id, descripcion, price)
    print(f"product ---> {product}")
    

    id = 2
    descripcion = "mouse"
    price = 1000.0
    
    pvp = Tax.computeTotal(price, 15)
    product2 = Product(id, descripcion, price)
    print(f"product 2 ---> {product2}")

if __name__ == "__main__":
    main()