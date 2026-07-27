import sys
import os

sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from models.sorting_context import SortingContext
from models.database_manager import DatabaseManager
from views.sort_view import SortView
from controllers.sort_controller import SortController


def main():
    context = SortingContext()
    db_manager = DatabaseManager()
    view = SortView()
    controller = SortController(view=view, context=context, db_manager=db_manager)
    view.mainloop()


if __name__ == "__main__":
    main()
