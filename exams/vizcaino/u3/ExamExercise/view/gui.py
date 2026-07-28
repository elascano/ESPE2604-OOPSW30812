import tkinter as tk
from controller.controller import SortController

class SortingGUI:

    def __init__(self):

        self.controller = SortController()


        self.window = tk.Tk()

        self.window.title(
            "Strategy Pattern Sorting"
        )

        self.window.geometry(
            "600x500"
        )


        self.create_widgets()



    def create_widgets(self):


        self.label = tk.Label(
            self.window,
            text="Enter numbers separated by commas:"
        )

        self.label.pack(
            pady=10
        )



        self.entry = tk.Entry(
            self.window,
            width=40
        )

        self.entry.pack()



        self.button = tk.Button(
            self.window,
            text="Sort Numbers",
            command=self.sort_numbers
        )

        self.button.pack(
            pady=10
        )



        self.result = tk.Label(
            self.window,
            text="",
            justify="left"
        )

        self.result.pack(
            pady=20
        )




    def sort_numbers(self):

        try:


            numbers = list(
                map(
                    int,
                    self.entry.get().split(",")
                )
            )


            sorted_numbers, algorithm = (
                self.controller.choose_algorithm(numbers)
            )



            self.result.config(

                text=f"""

Unsorted:
{numbers}

Size:
{len(numbers)}

Algorithm:
{algorithm}

Sorted:
{sorted_numbers}

"""

            )


        except Exception as e:


            self.result.config(

                text=f"Error: {e}"

            )




    def run(self):

        self.window.mainloop()
