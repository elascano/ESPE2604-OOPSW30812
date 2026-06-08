import json

filename = "products.json"
products = []

# Load existing data if file exists
try:
    with open(filename, "r") as file:
        products = json.load(file)
except:
    products = []

while True:
    print("\n===== PRODUCT MENU =====")
    print("1. Add product")
    print("2. View products")
    print("3. Calculate total")
    print("4. Exit")

    option = input("Choose an option: ")

    # -------------------
    # ADD PRODUCT
    # -------------------
    if option == "1":
        name = input("Product name: ")
        price = float(input("Product price: "))
        quantity = int(input("Product quantity: "))

        total = price * quantity

        product = {
            "name": name,
            "price": price,
            "quantity": quantity,
            "total": total
        }

        products.append(product)

        with open(filename, "w") as file:
            json.dump(products, file, indent=4)

        print("Product added successfully!")

    # -------------------
    # VIEW PRODUCTS
    # -------------------
    elif option == "2":
        print("\nPRODUCT LIST:\n")

        for p in products:
            print(f"Name: {p['name']}")
            print(f"Price: {p['price']}")
            print(f"Quantity: {p['quantity']}")
            print(f"Total: {p['total']}\n")

    # -------------------
    # CALCULATE TOTAL
    # -------------------
    elif option == "3":
        grand_total = 0

        for p in products:
            grand_total += p["total"]

        print(f"\nGRAND TOTAL: {grand_total}")

    # -------------------
    # EXIT
    # -------------------
    elif option == "4":
        print("Goodbye!")
        break

    else:
        print("Invalid option. Try again.")