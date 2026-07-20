from model.stock import Stock


class IBM(Stock):

    def __init__(self, symbol, price):
        super().__init__(symbol, price)