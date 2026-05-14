from datetime import datetime

from model.chicken import Chicken


class ChickenController:

    def __init__(self, view):

        self.view = view
        self.chickens = []

    def start(self):

        for i in range(2):

            self.view.show_message(
                f"\nEnter data for chicken {i + 1}"
            )

            id = int(input("Id: "))

            name = input("Name: ")

            color = input("Color: ")

            age = int(input("Age: "))

            is_molting = input(
                "Is molting (True/False): "
            ) == "True"

            chicken = Chicken(
                id,
                name,
                color,
                datetime.now(),
                age,
                is_molting
            )

            self.chickens.append(chicken)

        self.view.show_message(
            "\n--- CHICKENS DATA ---"
        )

        for chicken in self.chickens:

            self.view.show_chicken(chicken)