from sorting_context import SortingContext

class SortApp:
    @staticmethod
    def main():
        data = [6]
        sc = SortingContext()
        sorted_list = sc.sort(data)

        print("Sorted data:", " ".join(map(str, sorted_list)))

if __name__ == "__main__":
    SortApp.main()