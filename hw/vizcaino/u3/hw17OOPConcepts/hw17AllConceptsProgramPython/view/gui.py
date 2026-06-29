import tkinter as tk
from tkinter import ttk

from model.user import User
from model.movie import Movie
from model.streaming_platform import StreamingPlatform
from controller.streaming_platform_controller import StreamingPlatformController

class StreamingGUI:

    def __init__(self):

        self.window = tk.Tk()
        self.window.title("Streaming Platform CRUD")
        self.window.geometry("900x600")

        self.controller = StreamingPlatformController()
        self.platform = StreamingPlatform("StreamFlix")

        tk.Label(self.window, text="Name").pack()
        self.name_entry = tk.Entry(self.window)
        self.name_entry.pack()

        tk.Label(self.window, text="Plan").pack()
        self.plan_entry = tk.Entry(self.window)
        self.plan_entry.pack()

        tk.Label(self.window, text="Movie").pack()
        self.movie_entry = tk.Entry(self.window)
        self.movie_entry.pack()

        tk.Button(self.window, text="Create", command=self.create_user).pack()
        tk.Button(self.window, text="Update", command=self.update_user).pack()
        tk.Button(self.window, text="Delete", command=self.delete_user).pack()
        tk.Button(self.window, text="Refresh", command=self.load_users).pack()

        self.table = ttk.Treeview(self.window, columns=("name", "plan"), show="headings")
        self.table.heading("name", text="Name")
        self.table.heading("plan", text="Plan")
        self.table.pack(fill="both", expand=True)

    def create_user(self):

        user = User(
            self.name_entry.get(),
            self.plan_entry.get()
        )

        movie = Movie(self.movie_entry.get(), 120)

        self.controller.create_user(user)
        self.platform.play_content(user, movie)

        self.load_users()

    def update_user(self):

        self.controller.update_user(
            self.name_entry.get(),
            self.plan_entry.get()
        )

        self.load_users()

    def delete_user(self):

        self.controller.delete_user(
            self.name_entry.get()
        )

        self.load_users()

    def load_users(self):

        for row in self.table.get_children():
            self.table.delete(row)

        users = self.controller.get_users()

        for user in users:
            self.table.insert("", "end", values=(user["name"], user["plan"]))

    def start(self):
        self.window.mainloop()