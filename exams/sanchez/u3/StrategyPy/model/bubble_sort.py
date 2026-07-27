from model.sorting_strategy import SortingStrategy

class BubbleSort(SortingStrategy):

    def sort(self, data):
        arr = data.copy()

        n = len(arr)

        for i in range(n):
            for j in range(n - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]

        return arr