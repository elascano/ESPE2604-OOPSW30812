from model.bubble_sort import BubbleSort
from model.insertion_sort import InsertionSort
from model.quick_sort import QuickSort


class SortingContext:

    def __init__(self):
        self.sorting_strategy = None

    def sort(self, data):
        self.sorting_strategy = self.set_sort_strategy(len(data))
        return self.sorting_strategy.sort(data)

    def set_sort_strategy(self, size):

        if 0 < size < 30:
            self.sorting_strategy = BubbleSort()

        elif 30 <= size < 100:
            self.sorting_strategy = InsertionSort()

        else:
            self.sorting_strategy = QuickSort()

        return self.sorting_strategy