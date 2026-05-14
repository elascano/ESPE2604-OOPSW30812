import sys
import os

sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from model.chicken import Chicken

def main():
    chicken = Chicken(1, "Lucy", "White and brown", 1, True)
    print(f"My chicken is --> {chicken}")

if __name__ == "__main__":
    main()