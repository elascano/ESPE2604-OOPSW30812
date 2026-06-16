import json
import os
from typing import List, Dict, Any
from model.Product import Product

BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
JSON_FILE_PATH = os.path.join(BASE_DIR, 'data', 'products.json')

products_list: List[Dict[str, Any]] = []
shopping_cart: List[Dict[str, Any]] = []


def load_products_data() -> None:
    global products_list
    os.makedirs(os.path.dirname(JSON_FILE_PATH), exist_ok=True)
    
    if os.path.exists(JSON_FILE_PATH):
        try:
            with open(JSON_FILE_PATH, 'r', encoding='utf-8') as file:
                products_list = json.load(file)
        except (json.JSONDecodeError, FileNotFoundError):
            products_list = []
            save_products_to_file()
    else:
        products_list = []
        save_products_to_file()


def save_products_to_file() -> None:
    with open(JSON_FILE_PATH, 'w', encoding='utf-8') as file:
        json.dump(products_list, file, indent=2, ensure_ascii=False)


def display_products() -> None:
    print('\n==== PRODUCT LIST ====\n')
    if not products_list:
        print("No products available.")
        return
        
    for product in products_list:
        print(f"ID: {product['id']}")
        print(f"Name: {product['name']}")
        print(f"Category: {product['category']}")
        print(f"Price: ${product['price']:.2f}\n")


def add_new_product() -> None:
    try:
        name = input('Enter product name: ').strip()
        category = input('Enter product category: ').strip()
        price = float(input('Enter product price: '))
        
        if not name or not category or price < 0:
            print("\nInvalid inputs. Product not added.\n")
            return

        new_product = {
            "id": len(products_list) + 1,
            "name": name,
            "category": category,
            "price": price
        }
        
        products_list.append(new_product)
        save_products_to_file()
        print('\nProduct successfully added!\n')
    except ValueError:
        print('\nError: Invalid price format.\n')


def purchase_product() -> None:
    display_products()
    if not products_list:
        return

    try:
        product_id = int(input('Enter product ID to purchase: '))
        selected_raw = next((p for p in products_list if p['id'] == product_id), None)

        if not selected_raw:
            print('\nProduct not found.\n')
            return

        quantity = int(input('Enter quantity: '))
        if quantity <= 0:
            print('\nQuantity must be greater than 0.\n')
            return

        product_model = Product(
            selected_raw['id'], 
            selected_raw['name'], 
            selected_raw['category'], 
            selected_raw['price']
        )

        subtotal = product_model.calculate_subtotal(quantity)
        tax = product_model.calculate_tax(subtotal)
        total = product_model.calculate_total(subtotal, tax)

        shopping_cart.append({
            "name": product_model.name,
            "category": product_model.category,
            "quantity": quantity,
            "subtotal": subtotal,
            "tax": tax,
            "total": total
        })
        print('\nProduct successfully added to cart!\n')
    except ValueError:
        print('\nError: Invalid ID or Quantity entered.\n')


def display_invoice() -> None:
    print('\n==== INVOICE ====\n')
    if not shopping_cart:
        print("Your shopping cart is empty.")
        print('=========================\n')
        return

    total_subtotal = 0.0
    total_tax = 0.0
    total_amount = 0.0

    for item in shopping_cart:
        print(f"Product: {item['name']}")
        print(f"Quantity: {item['quantity']}")
        print(f"Subtotal: ${item['subtotal']:.2f}")
        print(f"Tax: ${item['tax']:.2f}")
        print(f"Total: ${item['total']:.2f}\n")
        
        total_subtotal += item['subtotal']
        total_tax += item['tax']
        total_amount += item['total']

    print('=========================')
    print(f"Subtotal: ${total_subtotal:.2f}")
    print(f"Tax (12%): ${total_tax:.2f}")
    print(f"Total Amount: ${total_amount:.2f}")
    print('=========================\n')


def update_product() -> None:
    display_products()
    if not products_list:
        return

    try:
        product_id = int(input('Enter product ID to update: '))
        product = next((p for p in products_list if p['id'] == product_id), None)

        if not product:
            print('\nProduct not found.\n')
            return

        new_name = input('Enter new name: ').strip()
        new_category = input('Enter new category: ').strip()
        new_price = float(input('Enter new price: '))

        if new_name: product['name'] = new_name
        if new_category: product['category'] = new_category
        if new_price >= 0: product['price'] = new_price

        save_products_to_file()
        print('\nProduct updated successfully!\n')
    except ValueError:
        print('\nError: Invalid input format.\n')


def display_menu() -> None:
    load_products_data()
    while True:
        print("======== MENU ========")
        print("1. Display products")
        print("2. Add product")
        print("3. Purchase product")
        print("4. Show invoice")
        print("5. Update product")
        print("6. Exit")
        print("======================")
        
        option = input('Select an option: ').strip()
        
        if option == '1': display_products()
        elif option == '2': add_new_product()
        elif option == '3': purchase_product()
        elif option == '4': display_invoice()
        elif option == '5': update_product()
        elif option == '6':
            print('\nGoodbye!\n')
            break
        else:
            print('\nInvalid option. Please try again.\n')