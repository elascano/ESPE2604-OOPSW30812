import sys
import os
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from model.teller import Teller
from model.clerk import Clerk
from model.manager import Manager
from model.president import President
from view.organization_view import OrganizationView
from controller.organization_controller import OrganizationController

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
    
    view = OrganizationView()
    controller = OrganizationController(pete, view)
    
    controller.update_view()

if __name__ == "__main__":
    main()
