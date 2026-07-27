from sorting_strategy import SortingStrategy

class BubbleSort(SortingStrategy):
    def sort(self, data):
        print("Sorting using BubbleSort")
        arr = list(data)
        n = len(arr)
        for i in range(n - 1):
            for j in range(0, n - i - 1):
                if arr[j] > arr[j + 1]:
                    arr[j], arr[j + 1] = arr[j + 1], arr[j]
        return arr