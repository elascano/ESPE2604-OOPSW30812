from model.sorting_strategy import SortingStrategy

class QuickSort(SortingStrategy):
    def sort(self, data):
        if len(data) <= 1: return data
        p = data[len(data) // 2]
        return self.sort([x for x in data if x < p]) + [x for x in data if x == p] + self.sort([x for x in data if x > p])