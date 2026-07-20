"""
@author Cristian Palomo, Error 404, @ESPE
"""
from ec_edu_espe.observer.model.investor import Investor
from ec_edu_espe.observer.model.stock import Stock
from ec_edu_espe.observer.view.stock_view import StockView


class Financier(Investor):

    def __init__(self, name: str) -> None:
        self.name = name
        self.observer_state: object = None
        self.stock: Stock | None = None

    def update(self, stock: Stock, args: object) -> None:
        self.stock = stock
        StockView.print_notification(self.name, stock, args)
