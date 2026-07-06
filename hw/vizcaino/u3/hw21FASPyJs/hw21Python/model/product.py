from dataclasses import dataclass


@dataclass
class Product:
    id: int
    description: str
    unit: str
    quantity: float