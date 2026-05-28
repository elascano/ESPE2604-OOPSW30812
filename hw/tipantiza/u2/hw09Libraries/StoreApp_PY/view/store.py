

from model.product import Product
from utils.tax import Tax

def main():

    id = 1
    description = "computer"
    price = 100

    pvp = Tax.compute_total(price, 15)
    product = Product(id, description, price)
    print("product --->", product)

    id = 2
    description = "mouse"
    price = 1000

    pvp = Tax.compute_total(price, 15)
    product2 = Product(id, description, price)
    print("product --->", product2)


if __name__ == "__main__":
    main()