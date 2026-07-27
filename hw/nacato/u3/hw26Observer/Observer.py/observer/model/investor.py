from controller.i_investor import IInvestor

class Investor(IInvestor):

    def __init__(self, name):
        self.name = name

    def update(self, stock, args):
        print(f"Notified observer {self.name}")

        if isinstance(args, str):
            print(f"The symbol of {stock.symbol} changed to: {args}")
        elif isinstance(args, float):
            print(f"The price of {stock.symbol} changed to: {args}")