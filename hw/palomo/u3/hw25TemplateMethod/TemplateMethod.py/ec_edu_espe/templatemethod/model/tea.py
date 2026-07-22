"""
@author Cristian Palomo, Error 404, @ESPE
"""
from ec_edu_espe.templatemethod.model.caffeine_beverage import CaffeineBeverage


class Tea(CaffeineBeverage):

    def brew(self) -> None:
        print("Steep the tea")

    def add_condiments(self) -> None:
        print("Adding lemon")

    def wants_condiments(self) -> bool:
        answer = self._get_user_input("Would you like lemon with your tea (y/n)? ")
        return answer.lower().startswith("y")

    def _get_user_input(self, prompt: str) -> str:
        try:
            answer = input(prompt)
        except EOFError:
            answer = None
        if answer is None:
            return "no"
        return answer
