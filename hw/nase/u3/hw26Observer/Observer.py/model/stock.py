from abc import ABC, abstractmethod

# Jennyfer Nase

class Stock(ABC):
    def __init__(self):
        self._symbol = ""
        self._price = 0.0
        self._investors = [] 

    def add_observer(self, iinvestor):
        if iinvestor not in self._investors:
            self._investors.append(iinvestor)

    def delete_observer(self, iinvestor):
        self._investors.remove(iinvestor)

    def notify_observers(self, args):
        for investor in self._investors:
            investor.update(self, args)

    @abstractmethod
    def get_symbol(self) -> str:
        pass

    @abstractmethod
    def get_price(self) -> float:
        pass