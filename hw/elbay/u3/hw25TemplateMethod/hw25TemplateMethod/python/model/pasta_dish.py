from model.meal_preparation import MealPreparation


class PastaDish(MealPreparation):
    def cook(self):
        print("Boiling pasta and simmering sauce")

    def add_garnish(self):
        print("Adding grated parmesan and basil")
