from model.ibm import IBM
from model.investor import Investor


def main():

    ibm = IBM("IBM", 120.00)

    investor1 = Investor("Sorros")
    investor2 = Investor("Berkshire")

    ibm.add_investor(investor1)
    ibm.add_investor(investor2)

    ibm.set_price(121.00)

    ibm.set_symbol("IBM Corporation")

    ibm.remove_investor(investor1)

    ibm.set_price(125.00)


if __name__ == "__main__":
    main()