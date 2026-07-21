from model.i_investor import IInvestor
from view.stock_view import StockView

class Investor(IInvestor):
    def __init__(self, name: str):
        self.name = name
        self.observer_state = ""
        self.stock = None

    def update(self, stock, args):
        self.stock = stock
        StockView.print_notification(self.name, stock, args)