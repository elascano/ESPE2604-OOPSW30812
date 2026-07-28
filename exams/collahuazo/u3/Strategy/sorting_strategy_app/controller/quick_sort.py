from controller.sorting_strategy import SortingStrategy


class QuickSort(SortingStrategy):
    def sort(self, arr: list) -> list:
        a = arr.copy()
        self._quick_sort(a, 0, len(a) - 1)
        return a

    def _quick_sort(self, a: list, low: int, high: int) -> None:
        if low < high:
            pivot_index = self._partition(a, low, high)
            self._quick_sort(a, low, pivot_index - 1)
            self._quick_sort(a, pivot_index + 1, high)

    def _partition(self, a: list, low: int, high: int) -> int:
        pivot = a[high]
        i = low - 1
        for j in range(low, high):
            if a[j] <= pivot:
                i += 1
                a[i], a[j] = a[j], a[i]
        a[i + 1], a[high] = a[high], a[i + 1]
        return i + 1
