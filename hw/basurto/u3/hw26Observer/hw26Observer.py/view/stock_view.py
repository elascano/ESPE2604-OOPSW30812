class StockView:
    @staticmethod
    def print_notification(investor_name, stock, args):
        print(f"Notified observer {investor_name}")
        if isinstance(args, str):
            print(f"The symbol of {stock.symbol} changed to: {args}")
        elif isinstance(args, (int, float)):
            print(f"The price of {stock.symbol} changed to: {args:.2f}")