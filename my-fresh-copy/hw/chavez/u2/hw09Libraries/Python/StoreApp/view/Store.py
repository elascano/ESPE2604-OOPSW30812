import sys
import os
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from model.Product import Product

def main():
    id = 1
    description = "computer"
    price = 100
    product = Product(id, description, price)
    print("Product 1 -->", product)
    id = 2
    description = "mouse"
    price = 1000
    product = Product(id, description, price)
    print("Product 2 -->", product)

if __name__ == "__main__":
    main()
