from model.teller import Teller
from model.clerk import Clerk
from model.manager import Manager
from model.president import President
from controller.client import Client


def main():

    loony = Teller("Loony")
    cal = Clerk("Cal")

    able = Manager("Able")
    able.add(loony)
    able.add(cal)

    juanita = Teller("Juanita")
    tina = Teller("Tina")
    thelma = Teller("Thelma")

    becky = Manager("Becky")
    becky.add(juanita)
    becky.add(tina)
    becky.add(thelma)

    pete = President("Pete")
    pete.add(able)
    pete.add(becky)

    Client.employee = pete
    Client.doClientTasks()


if __name__ == "__main__":
    main()