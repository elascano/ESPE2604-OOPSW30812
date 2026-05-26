import sys
from pathlib import Path

# Add python directory to path so taxes_lib and store_app can be found
python_dir = str(Path(__file__).resolve().parents[2])
if python_dir not in sys.path:
    sys.path.append(python_dir)

from taxes_lib.tax import Tax
from store_app.model.product import Product

def main():
    # Product 1
    id_val = 1
    description = "computer"
    price = 100.0
    
    # Replicating Java line 29: pvp = price + Tax.computeTotal(price, 15F);
    pvp = price + Tax.compute_total(price, 15.0)
    
    # Constructor sets pvp via internal Tax.compute_total(price, 15.0)
    product = Product(id_val, description, price)
    print("product -->" + str(product))
    
    # Product 2
    id_val = 2
    description = "mouse"
    price = 1000.0
    
    # Replicating Java line 39: pvp = price + Tax.computeTotal(price, 15F);
    pvp = price + Tax.compute_total(price, 15.0)
    
    # Constructor sets pvp to the passed pvp value
    product2 = Product(id_val, description, price, pvp)
    
    print("product 2 -->" + str(product2))

if __name__ == "__main__":
    main()
