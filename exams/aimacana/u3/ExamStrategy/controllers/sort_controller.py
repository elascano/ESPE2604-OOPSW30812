from models.sorting_context import SortingContext
from models.database_manager import DatabaseManager
from views.sort_view import SortView


class SortController:

    def __init__(self, view: SortView, context: SortingContext, db_manager: DatabaseManager):
        self.view = view
        self.context = context
        self.db_manager = db_manager

        self.view.bind_sort(self.handle_sort)
        self.handle_refresh()

    def handle_sort(self):
        raw_input = self.view.get_input_string()
        if not raw_input:
            self.view.show_error("Error", "Ingrese números separados por comas.")
            return

        try:
            items = [int(val.strip()) for val in raw_input.split(",") if val.strip()]
        except ValueError:
            self.view.show_error("Error", "Ingrese números enteros válidos separados por comas.")
            return

        if len(items) <= 1:
            self.view.show_error("Error", f"El tamaño ({len(items)}) debe ser mayor a 1 elemento.")
            return

        try:
            sorted_items, algorithm_name = self.context.sort(items)

            unsorted_str = ", ".join(map(str, items))
            sorted_str = ",".join(map(str, sorted_items))
            size = len(items)

            self.db_manager.save_sort_record(
                unsorted_str=unsorted_str,
                size=size,
                sort_algorithm=algorithm_name,
                sorted_str=sorted_str
            )

            self.view.display_results(
                unsorted_str=unsorted_str,
                size=size,
                algorithm_name=algorithm_name,
                sorted_str=f"{', '.join(map(str, sorted_items))}"
            )

            self.handle_refresh()

        except Exception as e:
            self.view.show_error("Error", f"Error al ordenar: {str(e)}")

    def handle_refresh(self):
        records = self.db_manager.fetch_all_records()
        self.view.populate_table(records)
