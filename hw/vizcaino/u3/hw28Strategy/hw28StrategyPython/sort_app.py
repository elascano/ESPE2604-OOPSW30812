from sorting_context import SortingContext

class SortApp:
    @staticmethod
    def main():
        data = [3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3]
        sc = SortingContext()
        sorted_list = sc.sort(data)

        print("Sorted data:", " ".join(map(str, sorted_list)))

if __name__ == "__main__":
    SortApp.main()