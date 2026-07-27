from view.beverage_view import BeverageView
from controller.beverage_controller import BeverageController
#@author Esteban Basurto, CodeBreakers,@ESPE
if __name__ == "__main__":
    view = BeverageView()
    controller = BeverageController(view)

    controller.prepare_tea()
    controller.prepare_coffee()