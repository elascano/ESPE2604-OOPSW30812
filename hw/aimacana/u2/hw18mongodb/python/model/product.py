from decimal import Decimal
from model.product_category import ProductCategory

class Product:
    def __init__(self, product_id: str = "", name: str = "", price: Decimal = Decimal('0.0'), category: ProductCategory = ProductCategory.HOT_BEVERAGE):
        self.product_id = product_id
        self.name = name
        self.price = price
        self.category = category

    def to_dict(self) -> dict:
        return {
            "productId": self.product_id,
            "name": self.name,
            "price": float(self.price),
            "category": self.category.value
        }

    @classmethod
    def from_dict(cls, data: dict):
        if not data:
            return None
        return cls(
            product_id=data.get("productId", ""),
            name=data.get("name", ""),
            price=Decimal(str(data.get("price", 0.0))),
            category=ProductCategory(data.get("category", "HOT_BEVERAGE"))
        )

    def __str__(self) -> str:
        return f"Product{{productId='{self.product_id}', name='{self.name}', price={self.price}, category={self.category.name}}}"
