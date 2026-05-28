import sys
import os
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))


from model import product
from utils import tax

def main():
    
    id_val = 1
    description = "Computer"
    price = 100.0

    
    pvp = tax.Tax.compute_total(price, 15.0)
    
    
    product_obj = product.Product(id_val, description, price)
    print("product---> " + str(product_obj))

    
    id_val = 2
    description = "Mouse"
    price = 1000.0

    pvp = tax.Tax.compute_total(price, 15.0)
    product2 = product.Product(id_val, description, price)
    print("product---> " + str(product2))

if __name__ == "__main__":
    main()