"""
@author Cristian Palomo, Error 404, @ESPE
"""
from ec_edu_espe.observer.model.stock import Stock


class IBM(Stock):

    def __init__(self, symbol: str, price: float) -> None:
        super().__init__()
        self.symbol = symbol
        self.price = price
