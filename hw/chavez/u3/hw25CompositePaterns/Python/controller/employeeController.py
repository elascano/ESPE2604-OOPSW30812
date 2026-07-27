from model.manager import Manager
from model.president import President
from model.teller import Teller
from model.clerk import Clerk


class EmployeeController:

    def create_organization(self):

        able = Manager("Able")

        able.add(Teller("Lonny"))
        able.add(Clerk("Cal"))

        becky = Manager("Becky")

        becky.add(Teller("Juanita"))
        becky.add(Teller("Tina"))

        pete = President("Pete")

        pete.add(able)
        pete.add(becky)

        return pete