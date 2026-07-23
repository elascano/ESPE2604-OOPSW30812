from model.sorting_strategy import SortingStrategy


class BubbleSort(SortingStrategy):

    def sort(self, data):

        array = data.copy()

        for i in range(len(array) - 1):
            for j in range(len(array) - i - 1):
                if array[j] > array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]

        return array