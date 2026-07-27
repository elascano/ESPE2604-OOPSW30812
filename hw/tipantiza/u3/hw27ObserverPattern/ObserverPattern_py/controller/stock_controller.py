from model.ibm import IBM
from model.investor import Investor


class StockController:

    def run_simulation(self):

        soros = Investor("Soros")
        berkshire = Investor("Berkshire")

        ibm = IBM("IBM", 120.00)

        ibm.add_observer(soros)
        ibm.add_observer(berkshire) 

        ibm.set_price(120.10)
        ibm.set_price(121.00)
        ibm.set_price(120.50)
        ibm.set_price(120.75)
        ibm.set_symbol("IBMTEST")