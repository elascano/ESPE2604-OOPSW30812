from dataclasses import dataclass


@dataclass
class Product:
    id: str
    name: str
    unit_price: float
    stock: int

    def to_dict(self) -> dict:
        return {
            "id": self.id,
            "name": self.name,
            "unitPrice": self.unit_price,
            "stock": self.stock,
        }
