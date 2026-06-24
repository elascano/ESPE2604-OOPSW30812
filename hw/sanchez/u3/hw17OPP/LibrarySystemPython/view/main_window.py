import tkinter as tk
from tkinter import messagebox
import sys
import os

sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
from model.book import Book
from dao.mongo_book_dao import MongoBookDAO
from controller.book_controller import BookController

controller = BookController(
    MongoBookDAO()
)

window = tk.Tk()
window.title("Library System")
window.geometry("500x250")

tk.Label(window, text="Id").grid(row=0, column=0)
tk.Label(window, text="Title").grid(row=1, column=0)
tk.Label(window, text="Author").grid(row=2, column=0)

txt_id = tk.Entry(window)
txt_title = tk.Entry(window)
txt_author = tk.Entry(window)

txt_id.grid(row=0, column=1)
txt_title.grid(row=1, column=1)
txt_author.grid(row=2, column=1)


def save_book():

    book = Book(
        txt_id.get(),
        txt_title.get(),
        txt_author.get()
    )

    controller.save_book(book)

    messagebox.showinfo(
        "Success",
        "Book saved."
    )


def search_book():

    book = controller.get_book_by_id(
        txt_id.get()
    )

    if book is None:
        messagebox.showerror(
            "Error",
            "Book not found."
        )
        return

    txt_title.delete(0, tk.END)
    txt_author.delete(0, tk.END)

    txt_title.insert(0, book.title)
    txt_author.insert(0, book.author)


def show_books():

    books = controller.get_all_books()

    text = ""

    for book in books:
        text += str(book) + "\n"

    messagebox.showinfo(
        "Books",
        text
    )


def update_book():

    book = Book(
        txt_id.get(),
        txt_title.get(),
        txt_author.get()
    )

    controller.update_book(book)

    messagebox.showinfo(
        "Success",
        "Book updated."
    )


def delete_book():

    controller.delete_book(
        txt_id.get()
    )

    txt_id.delete(0, tk.END)
    txt_title.delete(0, tk.END)
    txt_author.delete(0, tk.END)

    messagebox.showinfo(
        "Success",
        "Book deleted."
    )


tk.Button(
    window,
    text="Save",
    command=save_book
).grid(row=3, column=0)

tk.Button(
    window,
    text="Search",
    command=search_book
).grid(row=3, column=1)

tk.Button(
    window,
    text="Show All",
    command=show_books
).grid(row=3, column=2)

tk.Button(
    window,
    text="Update",
    command=update_book
).grid(row=4, column=0)

tk.Button(
    window,
    text="Delete",
    command=delete_book
).grid(row=4, column=1)

window.mainloop()