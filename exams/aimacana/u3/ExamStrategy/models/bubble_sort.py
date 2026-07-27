from typing import List
from .sorting_strategy import SortingStrategy


class BubbleSort(SortingStrategy):

    @property
    def name(self) -> str:
        return "BubbleSort"

    def sort(self, data: List[int]) -> List[int]:
        arr = list(data)
        n = len(arr)
        for i in range(n):
            swapped = False
            for j in range(0, n - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
                    swapped = True
            if not swapped:
                break
        return arr
