from ec.edu.espe.chickenfarm.model.chicken import Chicken


def main():
    chicken = Chicken(1, "Lucy", "White and brown", 1, True)
    print("My chicken is --> " + str(chicken))


if __name__ == "__main__":
    main()