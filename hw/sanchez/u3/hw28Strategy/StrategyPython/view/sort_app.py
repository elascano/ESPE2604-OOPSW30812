from controller.sorting_context import SortingContext
from model.bubble_sort import BubbleSort
from model.insertion_sort import InsertionSort
from model.quick_sort import QuickSort


class SortApp:

    @staticmethod
    def print_array(data):

        for number in data:
            print(number, end=" ")

        print()

    @staticmethod
    def get_strategy_name(strategy):

        if isinstance(strategy, BubbleSort):
            return "Bubble Sort"

        if isinstance(strategy, InsertionSort):
            return "Insertion Sort"

        if isinstance(strategy, QuickSort):
            return "Quick Sort"

        return "Unknown Strategy"

    @staticmethod
    def run():

        data = [3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3]

        context = SortingContext()

        print("Original array:")
        SortApp.print_array(data)

        strategy = context.set_sort_strategy(len(data))

        print("\nStrategy selected:", SortApp.get_strategy_name(strategy))

        sorted_data = context.sort(data)

        print("\nSorted array:")
        SortApp.print_array(sorted_data)