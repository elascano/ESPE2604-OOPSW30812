from model.sorting_strategy import SortingStrategy

class SortingContext:
    def __init__(self):
        self.strategy = None

    def setSortStrategy(self, strategy: SortingStrategy):
        self.strategy = strategy

    def sort(self, data):
        return self.strategy.sort(data)