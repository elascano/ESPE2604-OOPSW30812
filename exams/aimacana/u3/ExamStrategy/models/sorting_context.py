from typing import List, Tuple
from .sorting_strategy import SortingStrategy
from .bubble_sort import BubbleSort
from .insertion_sort import InsertionSort
from .quick_sort import QuickSort


class SortingContext:

    def __init__(self, strategy: SortingStrategy = None):
        self._strategy: SortingStrategy = strategy

    def set_sort_strategy(self, strategy: SortingStrategy) -> None:
        self._strategy = strategy

    def get_sort_strategy(self) -> SortingStrategy:
        return self._strategy

    def select_strategy_by_size(self, size: int) -> SortingStrategy:
        if size <= 1:
            raise ValueError("Number of elements must be greater than 1.")
        
        if 2 <= size <= 6:
            strategy = BubbleSort()
        elif 7 <= size <= 10:
            strategy = InsertionSort()
        else:
            strategy = QuickSort()
            
        self.set_sort_strategy(strategy)
        return strategy

    def sort(self, data: List[int]) -> Tuple[List[int], str]:
        size = len(data)
        strategy = self.select_strategy_by_size(size)
        sorted_data = strategy.sort(data)
        return sorted_data, strategy.name
