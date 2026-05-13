from model.product import Product
from model.customer import Customer
from model.supplier import Supplier
from model.file_manager import FileManager


class ManageStore:

    def run(self):
        while True:
            print("\n=== SECURE STORE ===")
            print("1. Add Product")
            print("2. Add Customer")
            print("3. Add Supplier")
            print("4. Exit")

            option = input("Choose: ")

            if option == "1":
                p = Product(
                    int(input("ID: ")),
                    input("Name: "),
                    int(input("Stock: ")),
                    float(input("Price: "))
                )

                FileManager.save_product_csv(p)
                FileManager.save_product_json(p)
                print("Product saved")

            elif option == "2":
                c = Customer(
                    int(input("ID: ")),
                    input("Name: "),
                    input("Category: ")
                )

                FileManager.save_customer_csv(c)
                FileManager.save_customer_json(c)
                print("Customer saved")

            elif option == "3":
                s = Supplier(
                    int(input("ID: ")),
                    input("Name: "),
                    input("Email: ")
                )

                FileManager.save_supplier_csv(s)
                FileManager.save_supplier_json(s)
                print("Supplier saved")

            elif option == "4":
                print("Exit program")
                break

            else:
                print("Invalid option")