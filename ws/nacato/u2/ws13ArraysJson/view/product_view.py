from model.product_model import ProductModel

class ProductView:
    def __init__(self):
        self.model = ProductModel()
        self.shopping_cart = []

    def display_menu(self):
        print("\n" + "="*40)
        print("        PC COMPONENTS HARDWARE SHOP       ")
        print("="*40)
        print("1. View catalog and choose items to buy")
        print("2. Display shopping cart and total with VAT")
        print("3. Clear shopping cart")
        print("4. Exit")
        print("="*40)

    def run(self):
        while True:
            self.display_menu()
            option = input("Select an option (1-4): ").strip()

            if option == "1":
                self.interface_choose_products()
            elif option == "2":
                self.interface_display_totals()
            elif option == "3":
                self.shopping_cart.clear()
                print("\n[Info] The shopping cart has been cleared.")
            elif option == "4":
                print("\nThank you for visiting! Exiting the program...")
                break
            else:
                print("\n[Error] Invalid option. Please try again.")

    def interface_choose_products(self):
        catalog = self.model.read_catalog()
        
        if not catalog:
            print("\n[Error] No products available in the JSON catalog.")
            return

        while True:
            print("\n--- AVAILABLE PRODUCTS IN CATALOG ---")
            print(f"{'ID':<4} | {'Product Name':<25} | {'Base Price':<10}")
            print("-" * 47)
            for item in catalog:
                print(f"{item['id']:<4} | {item['product']:<25} | ${item['price']:<.2f}")
            print("-" * 47)
            
            selection = input("Enter the ID of the product to add (or type 'end' to finish): ").strip()
            
            if selection.lower() == 'end':
                break

            try:
                chosen_id = int(selection)
                matched_product = next((p for p in catalog if p['id'] == chosen_id), None)
                
                if matched_product:
                    vat, total = self.model.calculate_item_values(matched_product['price'])
                    
                    cart_item = {
                        "product": matched_product['product'],
                        "price": matched_product['price'],
                        "vat": vat,
                        "total": total
                    }
                    
                    self.shopping_cart.append(cart_item)
                    print(f"-> '{matched_product['product']}' added to your cart!")
                else:
                    print("[Error] That product ID does not exist in the catalog.")
            except ValueError:
                print("[Error] Please enter a valid number or type 'end'.")

    def interface_display_totals(self):
        print("\n--- YOUR PURCHASE SUMMARY (SELECTED ITEMS) ---")
        
        if not self.shopping_cart:
            print("\nYour shopping cart is empty. Choose items using option 1 first.")
            return

        print(f"{'Product':<22} | {'Base Price':<12} | {'VAT (15%)':<10} | {'Total':<10}")
        print("-" * 62)
        
        for p in self.shopping_cart:
            print(f"{p['product']:<22} | ${p['price']:<11.2f} | ${p['vat']:<9.2f} | ${p['total']:<.2f}")
        
        print("-" * 62)
        
        subtotal_g, vat_g, total_g = self.model.calculate_list_totals(self.shopping_cart)
        
        print(f"{'SELECTION SUBTOTAL:':<47} ${subtotal_g:.2f}")
        print(f"{'TOTAL VAT (15%):':<47} ${vat_g:.2f}")
        print(f"{'NET TOTAL TO PAY:':<47} ${total_g:.2f}")
        print("=" * 62)