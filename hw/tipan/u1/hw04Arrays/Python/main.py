from view.chicken_view import ChickenView

from controller.chicken_controller import (
    ChickenController
)

view = ChickenView()

controller = ChickenController(view)

controller.start()