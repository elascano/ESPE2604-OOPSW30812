from datetime import date

from model.Food import Food
from model.Product import Product
from model.SlaughterHouse import SlaughterHouse
from model.Pig import Pig
from model.Cow import Cow

food = Food(1, "Corn")

slaughter_house = SlaughterHouse(
    1,
    "ESPE Slaughter House",
    "Sangolqui",
    "0999999999"
)

pork = Product(
    1,
    "Pork",
    "kg",
    50
)

milk = Product(
    2,
    "Milk",
    "liters",
    20
)

cuts = []

pig = Pig(
    100,
    1,
    "Yorkshire",
    date(2025, 1, 10),
    105,
    slaughter_house,
    pork,
    cuts
)

cow = Cow(
    20,
    95,
    2,
    "Holstein",
    date(2024, 8, 20),
    450,
    slaughter_house,
    milk,
    cuts
)

print("========== PIG ==========")
pig.feed(food)
print("Ready for slaughter?", pig.is_ready_for_slaughter())

print()

print("========== COW ==========")
cow.feed(food)
print(cow.produce())
cow.measure_quantity("liters", 20)