from model.sorting_strategy import SortingStrategy

class InsertionSort(SortingStrategy):

    def sort(self, data):
        arr = data.copy()

        for i in range(1, len(arr)):
            key = arr[i]
            j = i - 1

            while j >= 0 and arr[j] > key:
                arr[j + 1] = arr[j]
                j -= 1

            arr[j + 1] = key

        return arr
