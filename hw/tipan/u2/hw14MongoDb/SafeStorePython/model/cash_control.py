class CashControl:
    def __init__(self, cashier, opening, closing):
        self.cashier = cashier
        self.opening = opening
        self.closing = closing
        self.difference = closing - opening