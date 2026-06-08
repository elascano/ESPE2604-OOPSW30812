from model.product import Product
from utils.tax import Tax


def main():

    id = 1
    description = "computer"
    price = 100

    pvp = Tax.compute_total(price, 15)

    product = Product(id, description, price)

    print("Product --->", product)

    id = 2
    description = "Mouse"
    price = 1000

    pvp = Tax.compute_total(price, 15)

    product2 = Product(id, description, price, pvp)

    print("Product2 --->", product2)


if __name__ == "__main__":
    main()