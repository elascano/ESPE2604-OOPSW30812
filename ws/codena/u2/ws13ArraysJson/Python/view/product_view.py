class ProductView:

    def show_menu(self):

        print("\n===== STORE SYSTEM =====")

        print("1. Add products and save to JSON")
        print("2. Read JSON and show weights in kilograms")
        print("3. Exit")

    def show_message(self, message):

        print(message)

    def show_products(self, products):

        print("\n=== PRODUCTS IN KILOGRAMS ===")

        for product in products:

            print(
                f"Name: {product['name']} | "
                f"Kilograms: "
                f"{product['weight_kilograms']:.2f} kg"
            )