import sys
import os

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from model.tea import Tea
from model.coffee import Coffee


def main():

    tea = Tea()
    coffee = Coffee()

    print("\nMaking tea...")
    tea.prepare_recipe()

    print("\nMaking coffee...")
    coffee.prepare_recipe()


if __name__ == "__main__":
    main()