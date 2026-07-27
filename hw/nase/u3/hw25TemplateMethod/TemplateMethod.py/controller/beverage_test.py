import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from model.tea import Tea
from model.coffee import Coffee
from view.beverage_view import BeverageView

# Jennyfer Nase

def main():
    view = BeverageView()
    
    tea = Tea()
    coffee = Coffee()
    
    view.print_message("\nMaking tea ...")
    tea.prepare_recipe()
    
    view.print_message("\nMaking coffee ...")
    coffee.prepare_recipe()

if __name__ == "__main__":
    main()
    