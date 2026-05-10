"""
@author Didier Elbay <Code_Bros , @ESPE>
"""

from datetime import datetime


class Chiken:

    def __init__(self, id, name, color, born_on_date, is_molting, age):
        self.id = id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date
        self.is_molting = is_molting
        self.age = age

    def __str__(self):
        return (
            f"Chiken{{id={self.id}, "
            f"name={self.name}, "
            f"color={self.color}, "
            f"bornOnDate={self.born_on_date}, "
            f"isMolting={self.is_molting}, "
            f"age={self.age}}}"
        )


chickens = [None] * 5

chickens[0] = Chiken(
    1,
    "Lucy",
    "brown and white",
    datetime.now(),
    False,
    1
)

chickens[1] = Chiken(
    2,
    "Didier Elbay",
    "Red",
    datetime(1999, 12, 1),
    True,
    0
)

chickens[2] = Chiken(
    3,
    "Jorge Lascano",
    "Black",
    datetime(2021, 8, 23),
    False,
    2
)

chickens[3] = Chiken(
    4,
    "Jose",
    "Violet",
    datetime(2006, 3, 10),
    True,
    0
)

chickens[4] = Chiken(
    5,
    "Pepito Perez",
    "Red",
    datetime(2008, 1, 12),
    True,
    0
)

for i in range(5):
    print(f"chicken [{i + 1}] {chickens[i]}")