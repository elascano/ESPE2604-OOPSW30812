from controller.sorting_context import SortingContext

from model.bubble_sort import BubbleSort
from model.insertion_sort import InsertionSort
from model.quick_sort import QuickSort
from model.mongodb import MongoDB


class AppController:

    def __init__(self):
        self.context = SortingContext()
        self.database = MongoDB()

    def execute(self, numbers):

        size = len(numbers)

        if size < 2:
            raise ValueError("Enter at least two numbers.")

        if 2 <= size <= 6:
            strategy = BubbleSort()

        elif 7 <= size <= 10:
            strategy = InsertionSort()

        else:
            strategy = QuickSort()

        self.context.set_strategy(strategy)

        sorted_numbers = self.context.sort(numbers)

        self.database.save(
            numbers,
            size,
            strategy.__class__.__name__,
            sorted_numbers
        )

        return strategy.__class__.__name__, sorted_numbers