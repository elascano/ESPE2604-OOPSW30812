from model.meal_preparation import MealPreparation


class SaladDish(MealPreparation):
    def cook(self):
        print("Chopping vegetables and mixing dressing")

    def add_garnish(self):
        print("Adding croutons and sesame seeds")
