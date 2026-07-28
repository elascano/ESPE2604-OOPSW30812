from controller.sorting_context import SortingContext
from controller.bubble_sort import BubbleSort
from controller.insertion_sort import InsertionSort
from controller.quick_sort import QuickSort
from model.sort_record import SortRecord
from utils.db_connection import DBConnection


class SortController:
    def __init__(self):
        self.context = SortingContext()
        self.db = DBConnection()

    def parse_input(self, text: str) -> list:
        parts = text.split(",")
        numbers = []

        for part in parts:
            part = part.strip()

            if part == "":
                continue

            try:
                number = int(part)
            except ValueError:
                raise ValueError("All elements must be separated by comas")

            numbers.append(number)

        if len(numbers) == 0:
            raise ValueError("Enter one number.")

        return numbers

    def select_algorithm(self, size: int) -> str:
        if size < 2:
            raise ValueError("The array must have more than one element")
        elif size >= 2 and size <= 6:
            self.context.setSortStrategy(BubbleSort())
            return "BubbleSort"
        elif size >= 7 and size <= 10:
            self.context.setSortStrategy(InsertionSort())
            return "InsertionSort"
        else:
            self.context.setSortStrategy(QuickSort())
            return "QuickSort"

    def numbers_to_text(self, numbers: list) -> str:
        text = ""
        for i in range(len(numbers)):
            text = text + str(numbers[i])
            if i < len(numbers) - 1:
                text = text + ", "
        return text

    def process(self, text: str) -> SortRecord:
        numbers = self.parse_input(text)
        size = len(numbers)

        algorithm_name = self.select_algorithm(size)
        sorted_numbers = self.context.sort(numbers)

        unsorted_str = self.numbers_to_text(numbers)
        sorted_str = self.numbers_to_text(sorted_numbers)

        record = SortRecord(unsorted_str, size, algorithm_name, sorted_str)

        inserted_id = self.db.insert_record(record.to_dict())
        record.saved = inserted_id is not None

        return record
