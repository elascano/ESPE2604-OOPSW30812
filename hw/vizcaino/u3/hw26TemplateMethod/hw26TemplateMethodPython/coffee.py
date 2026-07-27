from caffein_beverage import CaffeinBeverage

class Coffee(CaffeinBeverage):
    def brew(self):
        print("Dripping coffee through filter")

    def add_condiments(self):
        print("Adding sugar and milk")

    def wants_condiments(self):
        answer = self.get_user_input()
        return answer.lower().startswith("y")

    def get_user_input(self):
        try:
            answer = input("Would you like milk and sugar with your coffee (y/n)? ")
        except (IOError, KeyboardInterrupt):
            answer = "n"
        return answer if answer else "n"