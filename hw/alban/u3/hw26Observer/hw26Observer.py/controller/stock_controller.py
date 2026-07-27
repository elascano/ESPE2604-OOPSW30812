import sys
import os

# @author Christopher Lomas,<CodeBros,@ESPE>
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from model.ibm import IBM
from model.investor import Investor

class StockController:
    def start_application(self):
        s = Investor("Sorros")
        b = Investor("Berkshire")

        ibm = IBM("IBM", 120.00)
        ibm.add_observer(s)
        ibm.add_observer(b)

        ibm.price = 120.10
        ibm.price = 121.00
        ibm.price = 120.50
        ibm.price = 120.75
        ibm.symbol = "IBMTEST"

if __name__ == "__main__":
    controller = StockController()
    controller.start_application()