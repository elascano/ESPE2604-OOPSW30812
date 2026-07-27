from abc import ABC, abstractmethod

# Jennyfer Nase

class IInvestor(ABC):
    @abstractmethod
    def update(self, stock, args):
        pass