class SortRecord:
    def __init__(self, unsorted: str, size: int, algorithm: str, sorted_list: str):
        self.unsorted = unsorted
        self.size = size
        self.algorithm = algorithm
        self.sorted = sorted_list
        self.saved = False

    def to_dict(self) -> dict:
        return {
            "unsorted": self.unsorted,
            "size": self.size,
            "sort algorithm": self.algorithm,
            "sorted": self.sorted,
        }
