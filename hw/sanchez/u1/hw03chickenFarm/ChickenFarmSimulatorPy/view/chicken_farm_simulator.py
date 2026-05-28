 # "author": "Joel Sanchez, The Softwarriors, @ESPE"

from model.chicken import Chicken

def main():
    chicken = Chicken(1, "Lucy", "white and brown", 1, True)
    print(f"\nMy chicken --- {chicken}\n")

if __name__ == "__main__":
    main()