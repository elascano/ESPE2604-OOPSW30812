from model.tea import Tea
from model.coffee import Coffee

class BeverageController:
    def __init__(self, view):
        self.view = view

    def prepare_tea(self):
        self.view.show_message("\nMaking tea ...")
        tea = Tea()
        # Modifica el comportamiento del hook dinámicamente usando la Vista
        tea.wants_condiments = lambda: self.view.get_user_input("Would you like lemon with your tea (y/n)?").lower().startswith("y")
        tea.prepare_recipe()

    def prepare_coffee(self):
        self.view.show_message("\nMaking coffee ...")
        coffee = Coffee()
        # Modifica el comportamiento del hook dinámicamente usando la Vista
        coffee.wants_condiments = lambda: self.view.get_user_input("Would you like milk and sugar with your coffee (y/n)?").lower().startswith("y")
        coffee.prepare_recipe()