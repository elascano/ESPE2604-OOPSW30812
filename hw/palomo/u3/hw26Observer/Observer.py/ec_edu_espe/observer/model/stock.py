"""
@author Cristian Palomo, Error 404, @ESPE
"""
from abc import ABC
from typing import List, Optional

from ec_edu_espe.observer.model.investor import Investor


class Stock(ABC):

    def __init__(self) -> None:
        self.symbol: Optional[str] = None
        self.price: Optional[float] = None
        self._investors: List[Investor] = []

    def add_observer(self, investor: Investor) -> None:
        self._investors.append(investor)

    def delete_observer(self, investor: Investor) -> None:
        if investor in self._investors:
            self._investors.remove(investor)

    def notify_observers(self, args: object) -> None:
        for investor in list(self._investors):
            investor.update(self, args)

    def get_symbol(self) -> Optional[str]:
        return self.symbol

    def set_symbol(self, symbol: str) -> None:
        self.symbol = symbol
        self.notify_observers(symbol)

    def get_price(self) -> Optional[float]:
        return self.price

    def set_price(self, price: float) -> None:
        self.price = price
        self.notify_observers(float(price))
