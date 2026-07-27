from model.investor import Investor
from model.ibm import IBM

# Jennyfer Nase

class StockController:
    def __init__(self, view):
        self._view = view

    def start_simulation(self):
        self._view.print_welcome()

        s = Investor("Sorros")
        b = Investor("Berkshire")

        ibm = IBM("IBM", 120.00)

        ibm.add_observer(s)
        ibm.add_observer(b)

        ibm.set_price(120.10)
        ibm.set_price(121.00)
        ibm.set_price(120.50)
        ibm.set_price(120.75)
        ibm.set_symbol("IBMTEST")