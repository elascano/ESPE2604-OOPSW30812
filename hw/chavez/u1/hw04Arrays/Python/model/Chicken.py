from datetime import date

class Chicken:
    def __init__(self, name, color, age_in_years, molting, number_of_eggs, number_of_poops):
        self.name = name
        self.color = color
        self.age_in_years = age_in_years
        self.molting = molting
        self.number_of_eggs = number_of_eggs
        self.number_of_poops = number_of_poops

    def __str__(self):
        return f"Chicken(Name: {self.name},Color: {self.color}, Age in Years: {self.age_in_years}, Is Molting: {self.molting}, Number of Eggs: {self.number_of_eggs}, Number of Poops: {self.number_of_poops})"