"""
@author Cristian Palomo, Error 404, @ESPE
"""
from ec_edu_espe.templatemethod.model.coffee import Coffee
from ec_edu_espe.templatemethod.model.tea import Tea
from ec_edu_espe.templatemethod.view.beverage_view import BeverageView


def main() -> None:
    view = BeverageView()

    tea = Tea()
    coffee = Coffee()

    view.print_message("\nMaking tea ...")
    tea.prepare_recipe()

    view.print_message("\nMaking coffee ...")
    coffee.prepare_recipe()


if __name__ == "__main__":
    main()
