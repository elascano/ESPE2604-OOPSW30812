#Jennyfer Nase
from product import Product
from tax import Tax
def main():

    id = 1
    description = "computer"
    price = 100

    pvp = Tax.compute_total(price, 15)

    product = Product(id, description, price)

    print("product 1 -->", product)

    
    id = 2
    description = "mouse"
    price = 1000

    pvp = Tax.compute_total(price, 15)

    product2 = Product(id, description, price, pvp)

    print("product 2 -->", product2)


if __name__ == "__main__":
    main()