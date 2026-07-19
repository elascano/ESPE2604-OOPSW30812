class Stock:

    def __init__(self):
        self.symbol = ""
        self.price = 0.0
        self.investors = []

    def add_observer(self, investor):
        self.investors.append(investor)

    def delete_observer(self, investor):
        self.investors.remove(investor)

    def notify_observers(self, args):
        for investor in self.investors:
            investor.update(self, args)