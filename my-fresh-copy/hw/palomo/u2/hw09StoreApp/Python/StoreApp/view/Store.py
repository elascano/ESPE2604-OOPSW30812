import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from StoreApp.model.Product import Product
from StoreApp.libraries.Tax import Tax

def main():
    
    id = 1
    description = "computer"
    price = 100
    
    pvp = Tax.computeTotal(price, 15.0)
    
    product = Product(id, description, price)
    print("product -->" + str(product))
    
    id = 2
    description = "mouse"
    price = 1000
    
    pvp = price + Tax.computeTotal(price, 15.0)
    product2 = Product(id, description, price, pvp)
    
    print("product 2 -->" + str(product2))

if __name__ == "__main__":
    main()