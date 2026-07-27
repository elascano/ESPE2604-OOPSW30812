from model.sorting_strategy import SortingStrategy


class QuickSort(SortingStrategy):

    def sort(self, data):

        array = data.copy()
        self.quick_sort(array, 0, len(array) - 1)

        return array

    def quick_sort(self, array, low, high):

        if low < high:

            pivot = self.partition(array, low, high)

            self.quick_sort(array, low, pivot - 1)
            self.quick_sort(array, pivot + 1, high)

    def partition(self, array, low, high):

        pivot = array[high]
        i = low - 1

        for j in range(low, high):

            if array[j] <= pivot:

                i += 1
                array[i], array[j] = array[j], array[i]

        array[i + 1], array[high] = array[high], array[i + 1]

        return i + 1