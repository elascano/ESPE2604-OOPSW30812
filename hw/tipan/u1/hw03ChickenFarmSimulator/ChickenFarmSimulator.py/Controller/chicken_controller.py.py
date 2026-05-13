class ChickenController:

    def __init__(self, chicken, view):
        self.chicken = chicken
        self.view = view

    def start(self):

        option = 0

        while option != 7:

            self.view.show_menu()

            option = int(input("Select an option: "))

            if option == 1:
                self.view.show_information(self.chicken)

            elif option == 2:
                self.view.show_message(
                    f"\nAge: {self.chicken.age} years"
                )

            elif option == 3:
                self.view.show_message(
                    f"\nWeight: {self.chicken.weight:.2f} kg"
                )

            elif option == 4:
                self.view.show_message(
                    f"\nEggs per week: {self.chicken.eggs_per_week}"
                )

            elif option == 5:
                self.view.show_message(
                    f"\nFood type: {self.chicken.food_type}"
                )

            elif option == 6:
                self.view.show_message(
                    f"\nColor: {self.chicken.color}"
                )

            elif option == 7:
                self.view.show_message("\nExiting...")

            else:
                self.view.show_message("\nInvalid option")