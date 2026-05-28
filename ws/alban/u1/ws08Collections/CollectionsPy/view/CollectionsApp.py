from model.Person import Person
from controller.PersonController import PersonController
#  @author Christopher Lomas,CodeBros,ESPE
class CollectionsApp:
    @staticmethod
    def run():
        print("--- ESPE Collections App (Python) ---")
        controller = PersonController()

        p1 = Person(1, "Christopher Lomas", 20)
        p2 = Person(2, "Mayra Haro", 21)

        controller.add_person(p1)
        controller.add_person(p2)

        print("\nStored Data:")
        for person in controller.get_people():
            print(person)