"""
@author Cristian Palomo, Error 404, @ESPE
"""
from ec_edu_espe.observer.model.financier import Financier
from ec_edu_espe.observer.model.ibm import IBM


class StockController:
    def start_application(self) -> None:
        s = Financier("Sorros")
        b = Financier("Berkshire")

        ibm = IBM("IBM", 120.00)
        ibm.add_observer(s)
        ibm.add_observer(b)

        ibm.set_price(120.10)
        ibm.set_price(121.00)
        ibm.set_price(120.50)
        ibm.set_price(120.75)
        ibm.set_symbol("IBMTEST")


def main() -> None:
    StockController().start_application()


if __name__ == "__main__":
    main()
