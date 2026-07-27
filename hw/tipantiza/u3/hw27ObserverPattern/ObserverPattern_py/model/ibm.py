from model.stock import Stock


class IBM(Stock):

    def __init__(self, symbol, price):
        super().__init__()
        self.symbol = symbol
        self.price = price

    def set_price(self, price):
        self.price = price
        self.notify_observers(price)

    def set_symbol(self, symbol):
        self.symbol = symbol
        self.notify_observers(symbol)