from controller.sorting_strategy import SortingStrategy


class InsertionSort(SortingStrategy):
    def sort(self, arr: list) -> list:
        a = arr.copy()
        for i in range(1, len(a)):
            key = a[i]
            j = i - 1
            while j >= 0 and a[j] > key:
                a[j + 1] = a[j]
                j -= 1
            a[j + 1] = key
        return a
