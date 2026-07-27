import types

from model.pasta_dish import PastaDish
from model.salad_dish import SaladDish


class MealController:
    def __init__(self, view):
        self.view = view

    def prepare_pasta(self):
        self.view.show_message("\nPreparing pasta ...")
        pasta = PastaDish()

        def wants_garnish(self_instance):
            answer = self.view.get_user_input("Would you like parmesan on your pasta (y/n)?")
            return answer.lower().startswith("y")

        pasta.wants_garnish = types.MethodType(wants_garnish, pasta)
        pasta.prepare_meal()

    def prepare_salad(self):
        self.view.show_message("\nPreparing salad ...")
        salad = SaladDish()

        def wants_garnish(self_instance):
            answer = self.view.get_user_input("Would you like croutons on your salad (y/n)?")
            return answer.lower().startswith("y")

        salad.wants_garnish = types.MethodType(wants_garnish, salad)
        salad.prepare_meal()
