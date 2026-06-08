from view.product_view import ProductView
from controller.product_controller import ProductController


view = ProductView()

controller = ProductController(view)


def main_menu():

    while True:

        view.show_menu()

        option = input("\nChoose an option: ")

        match option:

            case "1":

                name = input(
                    "Enter product name: "
                )

                weight = float(
                    input(
                        "Enter weight in pounds: "
                    )
                )

                controller.add_product(
                    name,
                    weight
                )

                controller.save_products_to_json()

            case "2":

                controller.read_products_and_convert()

            case "3":

                print("\nProgram finished.")

                break

            case _:

                print("\nInvalid option.")


main_menu()