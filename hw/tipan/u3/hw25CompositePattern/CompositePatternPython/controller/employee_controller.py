from model.clerk import Clerk
from model.teller import Teller
from model.manager import Manager
from model.president import President


class EmployeeController:

    def build_organization(self):

        lonny = Teller("Lonny")
        cal = Clerk("Cal")
        susan = Teller("Susan")
        david = Clerk("David")

        able = Manager("Able")
        able.add(lonny)
        able.add(cal)
        able.add(susan)
        able.add(david)

        juanita = Teller("Juanita")
        tina = Teller("Tina")
        thelma = Teller("Thelma")
        kevin = Clerk("Kevin")
        laura = Clerk("Laura")

        becky = Manager("Becky")
        becky.add(juanita)
        becky.add(tina)
        becky.add(thelma)
        becky.add(kevin)
        becky.add(laura)

        robert = Teller("Robert")
        emily = Teller("Emily")
        sophia = Clerk("Sophia")
        daniel = Clerk("Daniel")

        michael = Manager("Michael")
        michael.add(robert)
        michael.add(emily)
        michael.add(sophia)
        michael.add(daniel)

        pete = President("Pete")
        pete.add(able)
        pete.add(becky)
        pete.add(michael)

        return pete