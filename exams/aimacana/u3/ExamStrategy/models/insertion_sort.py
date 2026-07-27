from typing import List
from .sorting_strategy import SortingStrategy


class InsertionSort(SortingStrategy):

    @property
    def name(self) -> str:
        return "InsertionSort"

    def sort(self, data: List[int]) -> List[int]:
        arr = list(data)
        for i in range(1, len(arr)):
            key = arr[i]
            j = i - 1
            while j >= 0 and arr[j] > key:
                arr[j + 1] = arr[j]
                j -= 1
            arr[j + 1] = key
        return arr
