from datetime import date

from model.cow import Cow
from model.pig import Pig
from model.product import Product
from model.slaughter_house import SlaughterHouse


def main():
    slaughter_house = SlaughterHouse(
        1,
        "Central Slaughter House",
        "Quito",
        "0999999999",
    )

    product = Product(
        1,
        "Milk",
        "Liters",
        0.0,
    )

    cuts = []

    pig = Pig(
        120.0,
        35.0,
        1,
        "Yorkshire",
        date(2024, 1, 1),
        130.0,
        slaughter_house,
        None,
        cuts,
    )

    cow = Cow(
        True,
        62.0,
        2,
        "Holstein",
        date(2022, 6, 1),
        550.0,
        slaughter_house,
        product,
        cuts,
    )

    print(pig)
    print(cow)

    print(pig.cut())

    cow.measure_quantity(
        "Liters",
        15.5,
    )

    print(cow.produce())
    print(cow.cut())


if __name__ == "__main__":
    main()