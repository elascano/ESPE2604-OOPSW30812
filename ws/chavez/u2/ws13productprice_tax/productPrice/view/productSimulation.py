class ProductSimulation:
     def menu(self):
          print("\n===== PRODUCT SYSTEM =====")
          print("1. Add Product")
          print("2. Show Total Tax")
          print("3. Exit")

          return input("Choose an option: ")

     def get_product_data(self):
          name = input("Enter product name: ")
          price = float(input("Enter product price: "))

          return name, price

     def show_message(self, message):
          print(message)

     def show_total_tax(self, total_tax):
          print(f"\nTotal Tax: {total_tax}\n")