from abc import ABC, abstractmethod


class Stock(ABC):

    def __init__(self, symbol, price):
        self.symbol = symbol
        self.price = price
        self.investors = []

    def add_investor(self, investor):
        self.investors.append(investor)

    def remove_investor(self, investor):
        self.investors.remove(investor)

    def notify_investors(self):
        for investor in self.investors:
            investor.update(self)

    def set_symbol(self, symbol):
        self.symbol = symbol
        self.notify_investors()

    def set_price(self, price):
        self.price = price
        self.notify_investors()

    def get_symbol(self):
        return self.symbol

    def get_price(self):
        return self.price