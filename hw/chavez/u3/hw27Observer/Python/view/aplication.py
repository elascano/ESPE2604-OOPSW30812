import sys
import os
sys.path.append(os.path.dirname(os.path.dirname(__file__)))
from model.ibm import IBM
from model.investor import Investor

def main():

    sorros = Investor("Sorros")
    berkshire = Investor("Berkshire")

    ibm = IBM("IBM", 120.00)

    ibm.add_observer(sorros)
    ibm.add_observer(berkshire)

    ibm.set_price(120.10)
    ibm.set_price(121.00)
    ibm.set_price(120.50)
    ibm.set_price(120.75)

    ibm.set_symbol("IBMTEST")


if __name__ == "__main__":
    main()