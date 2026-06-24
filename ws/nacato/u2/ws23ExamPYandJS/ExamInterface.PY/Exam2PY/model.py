class Bank:
    def __init__(self, id_bank: str, name: str, total_deposits: float, total_loans: float):
        self.id = id_bank
        self.name = name
        self.total_deposits = total_deposits
        self.total_loans = total_loans

    def compute_net_worth(self) -> float:
        return self.total_deposits - self.total_loans

    def __str__(self):
        return f"ID: {self.id} | Name: {self.name} | Net Worth: ${self.compute_net_worth():.2f}"