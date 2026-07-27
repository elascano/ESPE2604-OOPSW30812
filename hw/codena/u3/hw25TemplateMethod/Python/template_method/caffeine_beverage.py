from abc import ABC, abstractmethod


class CaffeineBeverage(ABC):

    def prepare_recipe(self):
        self.boil_water()
        self.brew()
        self.pour_in_cup()

        if self.wants_condiments():
            self.add_condiments()

    def boil_water(self):
        print("Boiling Water")

    def pour_in_cup(self):
        print("Pouring into cup")

    def wants_condiments(self):
        answer = self.get_user_input()
        return answer.strip().lower() == "y"

    @abstractmethod
    def brew(self):
        pass

    @abstractmethod
    def add_condiments(self):
        pass

    @abstractmethod
    def get_user_input(self):
        pass