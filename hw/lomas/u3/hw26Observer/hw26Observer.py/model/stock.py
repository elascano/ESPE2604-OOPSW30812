from abc import ABC

class Stock(ABC):
    def __init__(self):
        self._symbol = ""
        self._price = 0.0
        self._investors = []

    def add_observer(self, investor):
        self._investors.append(investor)

    def delete_observer(self, investor):
        self._investors.remove(investor)

    def notify_observers(self, args):
        for investor in self._investors:
            investor.update(self, args)

    @property
    def symbol(self):
        return self._symbol

    @symbol.setter
    def symbol(self, value):
        self._symbol = value
        self.notify_observers(value)

    @property
    def price(self):
        return self._price

    @price.setter
    def price(self, value):
        self._price = value
        self.notify_observers(float(value))