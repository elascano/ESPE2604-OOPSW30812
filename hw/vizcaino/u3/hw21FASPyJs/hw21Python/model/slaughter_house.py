from dataclasses import dataclass


@dataclass
class SlaughterHouse:
    id: int
    name: str
    address: str
    cellphone_number: str