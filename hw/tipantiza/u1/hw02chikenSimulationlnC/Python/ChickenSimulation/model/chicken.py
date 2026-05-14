class Chicken:

    def __init__(self, name, color, age_in_years, is_molting, number_of_eggs, number_of_poops):
        self.name = name
        self.color = color
        self.age_in_years = age_in_years
        self.is_molting = is_molting
        self.number_of_eggs = number_of_eggs
        self.number_of_poops = number_of_poops

    def show_information(self):
        print("\n---Chicken information---")
        print("Name:", self.name)
        print("Color:", self.color)
        print("Age in years:", self.age_in_years)
        print("Number of eggs:", self.number_of_eggs)
        print("Number of poops:", self.number_of_poops)

    def cluck(self):
        print("\nCluck cluck")

    def wander(self):
        print(f"\n{self.name} is wandering around")

    def eat(self):
        print(f"\n{self.name} is eating")

    def drink(self):
        print(f"\n{self.name} is drinking")

    def poop(self):
        self.number_of_poops += 1
        print(f"\n{self.name} pooped")
        print("Number of poops:", self.number_of_poops)

    def lay_an_egg(self):
        self.number_of_eggs += 1
        print(f"\n{self.name} laid an egg")
        print("Number of eggs:", self.number_of_eggs)