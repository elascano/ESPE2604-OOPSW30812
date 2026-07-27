from model.sorting_strategy import SortingStrategy

class InsertionSort(SortingStrategy):
    def sort(self, data):
        arr = list(data)
        for i in range(1, len(arr)):
            key, j = arr[i], i - 1
            while j >= 0 and key < arr[j]:
                arr[j + 1] = arr[j]
                j -= 1
            arr[j + 1] = key
        return arr