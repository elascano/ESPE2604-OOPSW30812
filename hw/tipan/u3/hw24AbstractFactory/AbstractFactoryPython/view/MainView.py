import tkinter as tk
from controller.widgetcontroller import WidgetController

class MainView:
    def __init__(self):
        self.window = tk.Tk()
        self.window.title("Abstract Factory Simulator")
        self.window.geometry("400x300")
        
        self.title = tk.Label(
            self.window,
            text="Abstract Factory Simulator",
            font=("Arial", 14)
        )
        self.title.pack(pady=10)
        
        self.button = tk.Button(
            self.window,
            text="Generate Widgets",
            command=self.generate
        )
        self.button.pack(pady=10)
        
        self.text = tk.Text(
            self.window,
            height=8,
            width=40
        )
        self.text.pack(pady=10)

    def generate(self):
        controller = WidgetController()
        result = controller.generate_widgets()
        self.text.delete("1.0", tk.END)
        self.text.insert(tk.END, result)

    def show(self):
        self.window.mainloop()