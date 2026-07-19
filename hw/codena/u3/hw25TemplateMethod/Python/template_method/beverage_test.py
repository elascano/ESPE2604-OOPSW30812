from tea import Tea
from coffee import Coffee


def main():
    tea = Tea()
    coffee = Coffee()

    print("\n---Making tea...---")
    tea.prepare_recipe()

    print("\n---Making coffee...---")
    coffee.prepare_recipe()


if __name__ == "__main__":
    main()