from caffein_beverage import CaffeinBeverage

class Tea(CaffeinBeverage):
    def brew(self):
        print("Steep the tea")

    def add_condiments(self):
        print("Adding lemon")

    def wants_condiments(self):
        answer = self.get_user_input()
        return answer.lower().startswith("y")

    def get_user_input(self):
        try:
            answer = input("Would you like lemon with your tea (y/n)? ")
        except (IOError, KeyboardInterrupt):
            answer = "n"
        return answer if answer else "n"