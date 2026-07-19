from model.iinvestor import IInvestor

# Jennyfer Nase

class Investor(IInvestor):
    def __init__(self, name: str):
        self._name = name
        self._observer_state = None
        self._stock = None

    def update(self, stock, args):
        print(f"Notified observer {self._name}")
        
        if isinstance(args, str):
            print(f"The symbol of {stock.get_symbol()} changed to: {args}")
            
        elif isinstance(args, (float, int)):
            print(f"The price of {stock.get_symbol()} changed to: {args}")