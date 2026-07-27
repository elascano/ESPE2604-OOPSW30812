from typing import List
from .sorting_strategy import SortingStrategy


class QuickSort(SortingStrategy):

    @property
    def name(self) -> str:
        return "QuickSort"

    def sort(self, data: List[int]) -> List[int]:
        arr = list(data)

        def _quick_sort(items: List[int]) -> List[int]:
            if len(items) <= 1:
                return items
            pivot = items[len(items) // 2]
            left = [x for x in items if x < pivot]
            middle = [x for x in items if x == pivot]
            right = [x for x in items if x > pivot]
            return _quick_sort(left) + middle + _quick_sort(right)

        return _quick_sort(arr)
