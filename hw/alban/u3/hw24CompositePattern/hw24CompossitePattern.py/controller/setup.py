import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from model.teller import Teller
from model.clerk import Clerk
from model.manager import Manager
from model.president import President
from view.client import Client
#@author Christopher Lomas,<CodeBros,@ESPE>
class Setup:
    @staticmethod
    def main():
        lonny = Teller("Lonny")
        cal = Clerk("Cal")
        able = Manager("Able")
        able.add(lonny)
        able.add(cal)

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
    Setup.main()