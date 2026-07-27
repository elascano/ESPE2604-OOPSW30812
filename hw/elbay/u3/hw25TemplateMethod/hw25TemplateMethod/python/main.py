from view.meal_view import MealView
from controller.meal_controller import MealController

if __name__ == "__main__":
    view = MealView()
    controller = MealController(view)

    controller.prepare_pasta()
    controller.prepare_salad()
