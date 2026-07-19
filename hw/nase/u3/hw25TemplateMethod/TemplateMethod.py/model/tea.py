from model.caffeine_beverage import CaffeineBeverage

# Jennyfer Nase

class Tea(CaffeineBeverage):
    
    def brew(self):
        print("Steep the tea")
        
    def add_condiments(self):
        print("Adding lemon")
        
    def wants_condiments(self):
        answer = self.get_user_input()
        return answer.lower().startswith('y')
        
    def get_user_input(self):
        try:
            answer = input("Would you like lemon with your tea (y/n)? ")
            if not answer:
                return "no"
            return answer
        except (IOError, KeyboardInterrupt):
            print("\nError reading input.")
            return "no"