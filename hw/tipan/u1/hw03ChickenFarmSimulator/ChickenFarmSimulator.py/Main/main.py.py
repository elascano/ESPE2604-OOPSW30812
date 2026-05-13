from model.chicken import Chicken
from view.chicken_view import ChickenView
from controller.chicken_controller import ChickenController


lucy = Chicken(
    "Lucy",
    3,
    2.2,
    5,
    "Corn and grains",
    "Brown"
)

view = ChickenView()

controller = ChickenController(lucy, view)

controller.start()