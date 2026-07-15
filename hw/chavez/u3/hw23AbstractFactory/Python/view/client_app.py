
import sys
import os

sys.path.append(os.path.dirname(os.path.dirname(__file__)))
from controller.gui_controller import GUIController

class ClientApp:

    def run(self):
        controller = GUIController()
        controller.start()


if __name__ == "__main__":
    app = ClientApp()
    app.run()