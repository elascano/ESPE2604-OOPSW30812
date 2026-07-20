"""
@author Cristian Palomo, Error 404, @ESPE
"""
from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from ec_edu_espe.observer.model.stock import Stock


class StockView:
    @staticmethod
    def print_notification(investor_name: str, stock: "Stock", args: object) -> None:
        print(f"Notified observer {investor_name}")
        if isinstance(args, str):
            print(f"The symbol of {stock.get_symbol()} changed to: {args}")
        elif isinstance(args, float):
            print(f"The price of {stock.get_symbol()} changed to: {args}")
