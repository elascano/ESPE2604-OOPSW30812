from model.product import Product

id = 1
description = "computer"
price = 100

product = Product(id, description, price)

print(product)
print(f"PVP = {product.pvp}")