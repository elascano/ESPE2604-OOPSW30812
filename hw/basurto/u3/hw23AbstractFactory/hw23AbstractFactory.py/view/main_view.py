import tkinter as tk
from controller.widget_controller import WidgetController

#@author Esteban Basurto,CodeBreakers,@ESPE


class MainView:
    def __init__(self, root):
        self.root = root
        self.root.title("Abstract Factory Simulator")
        self.root.geometry("400x250")
        self.controller = WidgetController()

        self.label = tk.Label(root, text="Abstract Factory Simulator")
        self.label.pack(pady=10)

        self.btn = tk.Button(root, text="Generate Widgets", command=self.on_generate)
        self.btn.pack(pady=5)

        self.output = tk.Text(root, height=5, width=40)
        self.output.pack(pady=10)

    def on_generate(self):
        result = self.controller.generate_widgets()
        self.output.delete("1.0", tk.END)
        self.output.insert(tk.END, result)