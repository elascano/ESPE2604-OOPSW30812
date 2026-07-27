from .caffeine_beverage import CaffeineBeverage

class Chocolate(CaffeineBeverage):
    def brew(self):
        print("Mixing chocolate powder with hot water")
    
    def add_condiments(self):
        print("Adding whipped cream")
    
    def wants_condiments(self):
        answer = input("Would you like whipped cream with your chocolate (y/n)? ")
        return answer.lower().startswith('y')