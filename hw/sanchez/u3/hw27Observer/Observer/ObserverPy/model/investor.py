from model.i_investor import IInvestor


class Investor(IInvestor):

    def __init__(self, name):
        self.name = name

    def update(self, stock):
        print(
            f"Notified {self.name} of "
            f"{stock.symbol} change to {stock.price}"
        )

    def get_name(self):
        return self.name