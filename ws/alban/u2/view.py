from controller import ProductController

def show_shop():
    controller = ProductController()
    
    while True:
        print("\n=========================================")
        print("          🛒 YOUR SHOPPING CART 🛒        ")
        print("=========================================")
        print("PRODUCT MENU:")
        
        catalog = controller.get_catalog_list()
        for i, prod in enumerate(catalog):
            print(f"{i + 1}. {prod.name:<15} -> ${prod.price:.2f}")
            
        print("-----------------------------------------")
        print("0. Finish shopping and checkout")
        print("=========================================")
        
        try:
            option = int(input("Select the number of the product you want: "))
            
            if option == 0:
                break
                
            success = controller.buy_product(option)
            if success:
                print("Successfully added! 🛍️")
            else:
                print("❌ Invalid option. Please try again.")
                
        except ValueError:
            print("❌ Please enter a valid number.")

    print("\n=========================================")
    print("            🧾 YOUR FINAL RECEIPT 🧾       ")
    print("=========================================")
    
    cart = controller.get_cart_list()
    if not cart:
        print("You didn't buy anything. See ya next time!")
    else:
        for prod in cart:
            print(f"{prod.name:<20} | ${prod.price:.2f}")
        print("-----------------------------------------")
        total = controller.get_cart_total()
        print(f"TOTAL NET TO PAY:    | ${total:.2f}")
        
    print("=========================================\n")

if __name__ == "__main__":
    show_shop()