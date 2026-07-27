from model.bubble_sort import BubbleSort
from model.insertion_sort import InsertionSort
from model.quick_sort import QuickSort
from utils.mongodb import save_result

class SortController:

    def choose_algorithm(self, numbers):

        size = len(numbers)

        if size < 2:
            return None, "Invalid size"

        if 2 <= size <= 6:
            strategy = BubbleSort()
            name = "BubbleSort"

        elif 7 <= size <= 10:
            strategy = InsertionSort()
            name = "InsertionSort"

        else:
            strategy = QuickSort()
            name = "QuickSort"


        result = strategy.sort(numbers)
        save_result(
            numbers,
            size,
            name,
            result
        )
        return result, name
