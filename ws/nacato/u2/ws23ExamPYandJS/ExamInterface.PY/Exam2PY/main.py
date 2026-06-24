from view import BankView
from controller import BankController

if __name__ == "__main__":
    vista = BankView()
    controller = BankController(vista)
    controller.start()