from model.stock import Stock

# Jennyfer Nase

class IBM(Stock):
    def __init__(self, symbol: str, price: float):
        super().__init__()
        self._symbol = symbol
        self._price = price

    def get_price(self) -> float:
        return self._price

    def set_price(self, price: float):
        self._price = price
        self.notify_observers(price)

    def get_symbol(self) -> str:
        return self._symbol

    def set_symbol(self, symbol: str):
        self._symbol = symbol
        self.notify_observers(symbol)