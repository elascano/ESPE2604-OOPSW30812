# author Jennyfer Nase
from person import Person

class PersonController:
    @staticmethod
    def get_extended_people(p1, p2):
       
        people_list = [p1, p2]
        for i in range(3, 8):
           
            people_list.append(Person(i, "Jennyfer", "2026-05-09", True))
        return people_list