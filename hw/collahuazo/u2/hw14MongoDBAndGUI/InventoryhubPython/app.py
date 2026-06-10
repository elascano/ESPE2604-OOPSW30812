import sys
import tkinter as tk
from typing import Any

try:
    from controllers import (
        get_all_customers,
        get_all_products,
        get_all_suppliers,
        insert_customer,
        insert_product,
        insert_supplier,
    )
    from models import Customer, Product, Supplier
    from views.main_view import InventoryHubGUI
except ImportError:
    from python_inventoryhub.controllers import (
        get_all_customers,
        get_all_products,
        get_all_suppliers,
        insert_customer,
        insert_product,
        insert_supplier,
    )
    from python_inventoryhub.models import Customer, Product, Supplier
    from python_inventoryhub.views.main_view import InventoryHubGUI


def insert_customer_cli() -> None:
    try:
        ruc = int(input("Customer RUC: ").strip())
        name = input("Customer Name: ").strip()
        address = input("Customer Address: ").strip()
        gmail_customer = input("Customer Gmail: ").strip()

        customer = Customer(ruc=ruc, name=name, address=address, gmail_customer=gmail_customer)
        insert_customer(customer)

        print("Customer saved successfully.")
    except ValueError:
        print("Error: The RUC must be a valid number.")
    except Exception as exc:
        print(f"Error saving customer: {exc}")


def insert_product_cli() -> None:
    try:
        product_id = input("Product ID: ").strip()
        name = input("Product Name: ").strip()
        unit_price = float(input("Unit Price: ").strip())
        stock = int(input("Stock: ").strip())

        product = Product(id=product_id, name=name, unit_price=unit_price, stock=stock)
        insert_product(product)

        print("Product inserted successfully.")
    except ValueError:
        print("Error: Please enter valid values for price and stock.")
    except Exception as exc:
        print(f"Error saving product: {exc}")


def insert_supplier_cli() -> None:
    try:
        ruc = input("Supplier RUC: ").strip()
        company_name = input("Company Name: ").strip()
        address = input("Supplier Address: ").strip()
        phone = input("Phone (10 digits): ").strip()
        email = input("Email: ").strip()

        supplier = Supplier(ruc=ruc, company_name=company_name, address=address, phone=phone, email=email)
        insert_supplier(supplier)

        print("Supplier saved successfully.")
    except ValueError as exc:
        print(f"Validation error: {exc}")
    except Exception as exc:
        print(f"Error saving supplier: {exc}")


def list_customers() -> None:
    documents = get_all_customers()
    if not documents:
        print("No records found.")
        return

    print("RUC | Name | Address | Gmail")
    print("-" * 60)
    for doc in documents:
        print(f"{doc.get('ruc', '')} | {doc.get('name', '')} | {doc.get('address', '')} | {doc.get('gmailCustomer', '')}")


def list_products() -> None:
    documents = get_all_products()
    if not documents:
        print("No records found.")
        return

    print("ID | Name | Unit Price | Stock")
    print("-" * 60)
    for doc in documents:
        print(f"{doc.get('id', '')} | {doc.get('name', '')} | {doc.get('unitPrice', '')} | {doc.get('stock', '')}")


def list_suppliers() -> None:
    documents = get_all_suppliers()
    if not documents:
        print("No records found.")
        return

    print("RUC | Company | Address | Phone | Email")
    print("-" * 80)
    for doc in documents:
        print(f"{doc.get('ruc', '')} | {doc.get('companyName', '')} | {doc.get('address', '')} | {doc.get('phone', '')} | {doc.get('email', '')}")


def menu() -> None:
    options: dict[str, tuple[str, Any]] = {
        "1": ("Insert Customer", insert_customer_cli),
        "2": ("Insert Product", insert_product_cli),
        "3": ("Insert Supplier", insert_supplier_cli),
        "4": ("List Customers", list_customers),
        "5": ("List Products", list_products),
        "6": ("List Suppliers", list_suppliers),
        "0": ("Exit", None),
    }

    while True:
        print("\nInventoryHub Python")
        for key, (label, _) in options.items():
            print(f"{key}. {label}")

        choice = input("Select an option: ").strip()
        if choice == "0":
            print("Goodbye.")
            break

        action = options.get(choice)
        if action is None:
            print("Invalid option. Try again.")
            continue

        _, func = action
        if func:
            func()


def main() -> None:
    if len(sys.argv) > 1 and sys.argv[1] in ("--cli", "-c"):
        menu()
    else:
        root = tk.Tk()
        InventoryHubGUI(root)
        root.mainloop()


if __name__ == "__main__":
    main()
