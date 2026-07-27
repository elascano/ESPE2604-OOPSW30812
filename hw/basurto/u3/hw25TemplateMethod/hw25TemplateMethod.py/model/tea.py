from model.caffeine_beverage import CaffeineBeverage

class Tea(CaffeineBeverage):
    def brew(self):
        print("Steep the tea")

    def add_condiments(self):
        print("Adding lemon")