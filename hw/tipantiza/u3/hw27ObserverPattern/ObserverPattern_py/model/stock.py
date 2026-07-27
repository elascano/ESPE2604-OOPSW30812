class Stock:

    def __init__(self):
        self.symbol = ""
        self.price = 0.0
        self._investors = []

    def add_observer(self, investor):
        self._investors.append(investor)

    def delete_observer(self, investor):
        self._investors.remove(investor)

    def notify_observers(self, args):
        for investor in self._investors:
            investor.update(self, args)

    def get_symbol(self):
        return self.symbol

    def get_price(self):
        return self.price