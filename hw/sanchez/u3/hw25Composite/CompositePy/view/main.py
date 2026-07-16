import sys
import os

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from model.president import President
from model.manager import Manager
from model.teller import Teller
from model.clerk import Clerk
from view.company_view import CompanyView
from controller.company_controller import CompanyController

president = President("Pete")

able = Manager("Able")
becky = Manager("Becky")
john = Manager("John")
sarah = Manager("Sarah")

able.add(Teller("Lonny"))
able.add(Clerk("Cal"))

becky.add(Teller("Juanita"))
becky.add(Teller("Tina"))

john.add(Teller("Thelma"))
john.add(Clerk("Emma"))

sarah.add(Teller("Michael"))
sarah.add(Teller("David"))
sarah.add(Clerk("Oliver"))

president.add(able)
president.add(becky)
president.add(john)
president.add(sarah)

view = CompanyView()
controller = CompanyController(president, view)

controller.display_organization()