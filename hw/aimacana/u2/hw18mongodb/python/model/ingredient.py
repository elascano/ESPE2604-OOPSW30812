from decimal import Decimal

class Ingredient:
    def __init__(self, ingredient_id: str = "", name: str = "", stock_quantity: Decimal = Decimal('0.0'), unit: str = "", minimum_alert_quantity: Decimal = Decimal('0.0')):
        self.ingredient_id = ingredient_id
        self.name = name
        self.stock_quantity = stock_quantity
        self.unit = unit
        self.minimum_alert_quantity = minimum_alert_quantity

    def to_dict(self) -> dict:
        return {
            "ingredientId": self.ingredient_id,
            "name": self.name,
            "stockQuantity": float(self.stock_quantity),
            "unit": self.unit,
            "minimumAlertQuantity": float(self.minimum_alert_quantity)
        }

    @classmethod
    def from_dict(cls, data: dict):
        if not data:
            return None
        return cls(
            ingredient_id=data.get("ingredientId", ""),
            name=data.get("name", ""),
            stock_quantity=Decimal(str(data.get("stockQuantity", 0.0))),
            unit=data.get("unit", ""),
            minimum_alert_quantity=Decimal(str(data.get("minimumAlertQuantity", 0.0)))
        )

    def __str__(self) -> str:
        return f"Ingredient{{ingredientId='{self.ingredient_id}', name='{self.name}', stockQuantity={self.stock_quantity}, unit='{self.unit}', minimumAlertQuantity={self.minimum_alert_quantity}}}"
