from controller.sorting_strategy import SortingStrategy


class SortingContext:
    def __init__(self, strategy: SortingStrategy = None):
        self._strategy = strategy

    def setSortStrategy(self, strategy: SortingStrategy) -> None:
        self._strategy = strategy

    def sort(self, arr: list) -> list:
        if self._strategy is None:
            raise ValueError("No have strategy selected")
        return self._strategy.sort(arr)
