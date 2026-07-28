from controller.sorting_strategy import SortingStrategy


class BubbleSort(SortingStrategy):
    def sort(self, arr: list) -> list:
        a = arr.copy()
        n = len(a)
        for i in range(n - 1):
            for j in range(n - 1 - i):
                if a[j] > a[j + 1]:
                    a[j], a[j + 1] = a[j + 1], a[j]
        return a
