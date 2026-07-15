from model.us_tax import USTax
from view.calculator_view import CalculatorView
from controller.calculator_controller import CalculatorController
#@author Christopher Lomas,<CodeBros,@ESPE>
if __name__ == "__main__":
    tax = USTax.get_instance()
    tax.sales_total()

    view = CalculatorView()
    controller = CalculatorController(view)
    controller.run_interactive_calculation()