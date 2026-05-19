# main.py

from view import ProductSimulation
from model import ProductPrice


def main():

    view = ProductSimulation()
    model = ProductPrice()

    while True:

        option = view.menu()

        if option == "1":

            name, price = view.get_product_data()

            model.add_product(name, price)

            view.show_message("Product added successfully")

        elif option == "2":

            total_tax = model.get_total_tax()

            view.show_total_tax(total_tax)

        elif option == "3":

            view.show_message("Goodbye")

            break

        else:

            view.show_message("Invalid option")


if __name__ == "__main__":
    main()