from teller import Teller
from clerk import Clerk
from manager import Manager
from president import President
from client import Client

class Setup:
    @staticmethod
    def main():
        daniel = Teller("Daniel")
        javier = Clerk("Javier")
        luis = Manager("Luis")
        luis.add(daniel)
        luis.add(javier)

        ian = Teller("Ian")
        victor = Teller("Victor")
        andres = Manager("Andres")
        andres.add(ian)
        andres.add(victor)

        carlos = President.get_president("Carlos")
        carlos.add(luis)
        carlos.add(andres)

        Client.employee = carlos;
        Client.do_client_tasks()

if __name__ == "__main__":
    Setup.main()