"""Sets up the org chart and initiates execution."""

from composite.controller.client import Client
from composite.model.clerk import Clerk
from composite.model.teller import Teller
from composite.model.manager import Manager
from composite.model.president import President


def main():
    # Make manager Able's organization
    lonny = Teller("Lonny")
    cal = Clerk("Cal")
    able = Manager("Able")
    able.add(lonny)
    able.add(cal)

    # Make manager Becky's organization
    juanita = Teller("Juanita")
    tina = Teller("Tina")
    thelma = Teller("Thelma")
    becky = Manager("Becky")
    becky.add(juanita)
    becky.add(tina)
    becky.add(thelma)


    pete = President.get_president("Pete")
    pete.add(able)
    pete.add(becky)


    Client.employee = pete
    Client.do_client_tasks()


if __name__ == "__main__":
    main()
