from model.caffeine_beverage import CaffeineBeverage

class Tea(CaffeineBeverage):
    def brew(self):
        print("Steeping the tea")

    def add_condiments(self):
        print("Adding lemon")

    def wants_condiments(self):
        answer = input("Would you like lemon with your tea (y/n)? ").strip().lower()
        return answer.startswith("y")