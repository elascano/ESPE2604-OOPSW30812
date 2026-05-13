class Chicken:
    def __init__(self, name, color, age_in_years, molting, number_of_eggs, number_of_poops):
        self.name = name
        self.color = color
        self.age_in_years = age_in_years
        self.molting = molting
        self.number_of_eggs = number_of_eggs
        self.number_of_poops = number_of_poops

    def show_information(self):
        print("\nChicken Information")
        print(f"Name: {self.name}")
        print(f"Color: {self.color}")
        print(f"Age in Years: {self.age_in_years}")    
        print(f"Is Molting: {self.molting}")
        print(f"Number of Eggs: {self.number_of_eggs}")
        print(f"Number of Poops: {self.number_of_poops}")

    def cluck(self):
        print("\nCluck cluck")
        
    def wander(self):
        print(f"\n{self.name} is wandering")

    def eat(self):
        print(f"\n{self.name} is eating")

    def drink(self):
        print(f"\n{self.name} is drinking")

    def poop(self):
        self.number_of_poops += 1
        print(f"\n{self.name} pooped")
        print(f"Number of Poops: {self.number_of_poops}")

    def lay_an_egg(self):
        self.number_of_eggs += 1
        print(f"\n{self.name} laid an egg")
        print(f"Number of Eggs: {self.number_of_eggs}")
