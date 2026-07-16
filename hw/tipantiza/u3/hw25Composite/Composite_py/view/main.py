import sys
import os
current_dir = os.path.dirname(os.path.abspath(__file__))
parent_dir = os.path.dirname(current_dir)
sys.path.append(current_dir)
sys.path.append(parent_dir)
from model.president import President
from model.manager import Manager
from model.teller import Teller
from model.clerk import Clerk
from view.company_view import CompanyView
from controller.company_controller import CompanyController

president = President("Alex")

able = Manager("Sandra")
becky = Manager("Nathalia")
john = Manager("German")
sarah = Manager("Henry")

able.add(Teller("Roxy"))
able.add(Clerk("Lenny"))

becky.add(Teller("Sonia"))
becky.add(Teller("Tania"))

john.add(Teller("Stefany"))
john.add(Clerk("Evelyn"))

sarah.add(Teller("Jorge"))
sarah.add(Teller("Dennis"))
sarah.add(Clerk("Ommar"))

president.add(able)
president.add(becky)
president.add(john)
president.add(sarah)

view = CompanyView()
controller = CompanyController(president, view)

controller.display_organization()