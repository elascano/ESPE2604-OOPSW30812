from datetime import date
from animalfarm import Cow, Pig, Sheep, Chicken, FarmBusinessLogic

cow = Cow(1, "Holstein", date(2022, 5, 1), 650.0, True, 25.0)
pig = Pig(2, "Yorkshire", date(2023, 2, 15), 110.0, 120.0)
sheep = Sheep(3, "Merino", date(2021, 9, 10), 70.0, date(2024, 3, 1))
chicken = Chicken(4, "Leghorn", date(2023, 11, 20), 2.5, False, 5)

print(FarmBusinessLogic.calculate_expected_meat_yield(cow))
print(FarmBusinessLogic.calculate_expected_meat_yield(pig))
print(FarmBusinessLogic.is_eligible_for_egg_production(chicken))
print(FarmBusinessLogic.calculate_milk_efficiency(cow))
