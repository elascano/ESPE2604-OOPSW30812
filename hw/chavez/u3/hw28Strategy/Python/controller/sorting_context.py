from model.bubble_sort import BubbleSort
from model.insertion_sort import InsertionSort
from model.quick_sort import QuickSort
class SortingContext:

    def sort(self, data):

        if len(data) < 30:
            strategy = BubbleSort()
        elif len(data) < 100:
            strategy = InsertionSort()
        else:
            strategy = QuickSort()

        return strategy.sort(data)