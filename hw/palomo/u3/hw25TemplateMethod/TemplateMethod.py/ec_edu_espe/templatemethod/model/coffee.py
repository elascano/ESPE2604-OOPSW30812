"""
@author Cristian Palomo, Error 404, @ESPE
"""
from ec_edu_espe.templatemethod.model.caffeine_beverage import CaffeineBeverage


class Coffee(CaffeineBeverage):

    def brew(self) -> None:
        print("Dripping coffee through filter")

    def add_condiments(self) -> None:
        print("Adding sugar and milk")

    def wants_condiments(self) -> bool:
        answer = self._get_user_input(
        )
        return answer.lower().startswith("y")

    def _get_user_input(self, prompt: str) -> str:
        try:
            answer = input(prompt)
        except EOFError:
            answer = None
        if answer is None:
            return "no"
        return answer
