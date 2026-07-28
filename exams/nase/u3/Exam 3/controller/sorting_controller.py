from model.sorting_context import SortingContext
from model.bubble_sort import BubbleSort
from model.quick_sort import QuickSort
from model.insertion_sort import InsertionSort
from model.database_repository import DatabaseRepository

# Jennyfer Nase

class SortingController:
    def __init__(self):
        self.context = SortingContext()
        self.db = DatabaseRepository("mongodb+srv://Jennyfer:jennyfer@jennyfer.owlaicw.mongodb.net/?appName=Jennyfer")

    def process(self, txt):
        nums = [int(x.strip()) for x in txt.split(",")]
        sz = len(nums)
        if sz <= 1: raise ValueError("Size must be > 1")
        
        st, name = (BubbleSort(), "BubbleSort") if sz <= 6 else (InsertionSort(), "InsertionSort") if sz <= 10 else (QuickSort(), "QuickSort")
        
        self.context.setSortStrategy(st)
        res = self.context.sort(nums)
        u_str, s_str = ", ".join(map(str, nums)), ", ".join(map(str, res))
        
        self.db.save(u_str, sz, name, s_str)
        return {"unsorted": u_str, "size": sz, "algorithm": name, "sorted": s_str}