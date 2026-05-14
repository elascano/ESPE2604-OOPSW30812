class ChickenView:

    def show_menu(self):
        print("\n--- MENU ---")
        print("1. Show all information")
        print("2. Show age")
        print("3. Show weight")
        print("4. Show eggs per week")
        print("5. Show food type")
        print("6. Show color")
        print("7. Exit")

    def show_information(self, chicken):
        print("\n--- LUCY INFORMATION ---")
        print(f"Name: {chicken.name}")
        print(f"Age: {chicken.age} years")
        print(f"Weight: {chicken.weight:.2f} kg")
        print(f"Eggs per week: {chicken.eggs_per_week}")
        print(f"Food type: {chicken.food_type}")
        print(f"Color: {chicken.color}")

    def show_message(self, message):
        print(message)