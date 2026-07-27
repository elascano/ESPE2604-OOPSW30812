import tkinter as tk
from tkinter import ttk, messagebox, simpledialog
from tkinter import StringVar
import uuid

from controller.library_controller import LibraryController
from model.book import Book
from model.user import User

class LibraryGUI:
    def __init__(self):
        self.controller = LibraryController()
        self.root = tk.Tk()
        self.root.title("Library Management System - ESPE")
        self.root.geometry("1200x800")
        
        self._create_menu()
        self._create_tabs()
        self._load_data()
    
    def run(self):
        self.root.mainloop()
    
    def _create_menu(self):
        menubar = tk.Menu(self.root)
        self.root.config(menu=menubar)
        
        file_menu = tk.Menu(menubar, tearoff=0)
        menubar.add_cascade(label="File", menu=file_menu)
        file_menu.add_command(label="Exit", command=self._exit_app)
        
        help_menu = tk.Menu(menubar, tearoff=0)
        menubar.add_cascade(label="Help", menu=help_menu)
        help_menu.add_command(label="About", command=self._show_about)
    
    def _create_tabs(self):
        self.notebook = ttk.Notebook(self.root)
        self.notebook.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        self._create_books_tab()
        self._create_users_tab()
        self._create_loans_tab()
        self._create_statistics_tab()
    
    def _create_books_tab(self):
        tab = ttk.Frame(self.notebook)
        self.notebook.add(tab, text="Books")
        
        columns = ("ID", "Title", "Author", "ISBN", "Year", "Available", "Category")
        self.book_tree = ttk.Treeview(tab, columns=columns, show="headings", height=15)
        
        for col in columns:
            self.book_tree.heading(col, text=col)
            self.book_tree.column(col, width=150 if col != "Title" else 200)
        
        scrollbar = ttk.Scrollbar(tab, orient=tk.VERTICAL, command=self.book_tree.yview)
        self.book_tree.configure(yscrollcommand=scrollbar.set)
        
        self.book_tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        
        button_frame = ttk.Frame(tab)
        button_frame.pack(fill=tk.X, pady=10)
        
        add_btn = ttk.Button(button_frame, text="Add Book", command=self._show_add_book_dialog)
        add_btn.pack(side=tk.LEFT, padx=5)
        
        delete_btn = ttk.Button(button_frame, text="Delete", command=self._delete_book)
        delete_btn.pack(side=tk.LEFT, padx=5)
        
        refresh_btn = ttk.Button(button_frame, text="Refresh", command=self._load_books)
        refresh_btn.pack(side=tk.LEFT, padx=5)
    
    def _create_users_tab(self):
        tab = ttk.Frame(self.notebook)
        self.notebook.add(tab, text="Users")
        
        columns = ("ID", "First Name", "Last Name", "Email", "Type", "Active Loans")
        self.user_tree = ttk.Treeview(tab, columns=columns, show="headings", height=15)
        
        for col in columns:
            self.user_tree.heading(col, text=col)
            self.user_tree.column(col, width=150)
        
        scrollbar = ttk.Scrollbar(tab, orient=tk.VERTICAL, command=self.user_tree.yview)
        self.user_tree.configure(yscrollcommand=scrollbar.set)
        
        self.user_tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        
        button_frame = ttk.Frame(tab)
        button_frame.pack(fill=tk.X, pady=10)
        
        add_btn = ttk.Button(button_frame, text="Add User", command=self._show_add_user_dialog)
        add_btn.pack(side=tk.LEFT, padx=5)
        
        delete_btn = ttk.Button(button_frame, text="Delete", command=self._delete_user)
        delete_btn.pack(side=tk.LEFT, padx=5)
        
        refresh_btn = ttk.Button(button_frame, text="Refresh", command=self._load_users)
        refresh_btn.pack(side=tk.LEFT, padx=5)
    
    def _create_loans_tab(self):
        tab = ttk.Frame(self.notebook)
        self.notebook.add(tab, text="Loans")
        
        columns = ("ID", "User ID", "Book ID", "Loan Date", "Status", "Fine")
        self.loan_tree = ttk.Treeview(tab, columns=columns, show="headings", height=10)
        
        for col in columns:
            self.loan_tree.heading(col, text=col)
            self.loan_tree.column(col, width=150)
        
        scrollbar = ttk.Scrollbar(tab, orient=tk.VERTICAL, command=self.loan_tree.yview)
        self.loan_tree.configure(yscrollcommand=scrollbar.set)
        
        self.loan_tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        
        operation_frame = ttk.LabelFrame(tab, text="Loan Operations")
        operation_frame.pack(fill=tk.X, pady=10, padx=10)
        
        ttk.Label(operation_frame, text="User ID:").grid(row=0, column=0, padx=5, pady=5)
        self.user_id_entry = ttk.Entry(operation_frame, width=20)
        self.user_id_entry.grid(row=0, column=1, padx=5, pady=5)
        
        ttk.Label(operation_frame, text="Book ID:").grid(row=0, column=2, padx=5, pady=5)
        self.book_id_entry = ttk.Entry(operation_frame, width=20)
        self.book_id_entry.grid(row=0, column=3, padx=5, pady=5)
        
        create_btn = ttk.Button(operation_frame, text="Create Loan", command=self._create_loan)
        create_btn.grid(row=1, column=0, columnspan=2, padx=5, pady=5)
        
        return_btn = ttk.Button(operation_frame, text="Return Book", command=self._return_loan)
        return_btn.grid(row=1, column=2, columnspan=2, padx=5, pady=5)
        
        refresh_btn = ttk.Button(operation_frame, text="Refresh", command=self._load_loans)
        refresh_btn.grid(row=1, column=4, padx=5, pady=5)
    
    def _create_statistics_tab(self):
        tab = ttk.Frame(self.notebook)
        self.notebook.add(tab, text="Statistics")
        
        stats_frame = ttk.LabelFrame(tab, text="System Statistics")
        stats_frame.pack(fill=tk.BOTH, expand=True, padx=20, pady=20)
        
        self.total_books_label = ttk.Label(stats_frame, text="Total Books: 0", font=("Arial", 12))
        self.total_books_label.pack(pady=10)
        
        self.available_books_label = ttk.Label(stats_frame, text="Available Books: 0", font=("Arial", 12))
        self.available_books_label.pack(pady=10)
        
        self.total_users_label = ttk.Label(stats_frame, text="Total Users: 0", font=("Arial", 12))
        self.total_users_label.pack(pady=10)
        
        self.active_loans_label = ttk.Label(stats_frame, text="Active Loans: 0", font=("Arial", 12))
        self.active_loans_label.pack(pady=10)
        
        refresh_btn = ttk.Button(stats_frame, text="Refresh Statistics", command=self._update_statistics)
        refresh_btn.pack(pady=20)
    
    def _show_add_book_dialog(self):
        dialog = tk.Toplevel(self.root)
        dialog.title("Add Book")
        dialog.geometry("400x350")
        dialog.transient(self.root)
        dialog.grab_set()
        
        ttk.Label(dialog, text="Title:").grid(row=0, column=0, padx=5, pady=5)
        title_entry = ttk.Entry(dialog, width=30)
        title_entry.grid(row=0, column=1, padx=5, pady=5)
        
        ttk.Label(dialog, text="Author:").grid(row=1, column=0, padx=5, pady=5)
        author_entry = ttk.Entry(dialog, width=30)
        author_entry.grid(row=1, column=1, padx=5, pady=5)
        
        ttk.Label(dialog, text="ISBN:").grid(row=2, column=0, padx=5, pady=5)
        isbn_entry = ttk.Entry(dialog, width=30)
        isbn_entry.grid(row=2, column=1, padx=5, pady=5)
        
        ttk.Label(dialog, text="Year:").grid(row=3, column=0, padx=5, pady=5)
        year_entry = ttk.Entry(dialog, width=30)
        year_entry.grid(row=3, column=1, padx=5, pady=5)
        
        ttk.Label(dialog, text="Category:").grid(row=4, column=0, padx=5, pady=5)
        category_entry = ttk.Entry(dialog, width=30)
        category_entry.grid(row=4, column=1, padx=5, pady=5)
        
        def save_book():
            try:
                book = Book(
                    id=str(uuid.uuid4()),
                    title=title_entry.get(),
                    author=author_entry.get(),
                    isbn=isbn_entry.get(),
                    publication_year=int(year_entry.get()),
                    category=category_entry.get()
                )
                self.controller.add(book)
                self._load_books()
                dialog.destroy()
                messagebox.showinfo("Success", "Book added successfully")
            except Exception as e:
                messagebox.showerror("Error", str(e))
        
        save_btn = ttk.Button(dialog, text="Save", command=save_book)
        save_btn.grid(row=5, column=0, columnspan=2, pady=20)
    
    def _show_add_user_dialog(self):
        dialog = tk.Toplevel(self.root)
        dialog.title("Add User")
        dialog.geometry("400x350")
        dialog.transient(self.root)
        dialog.grab_set()
        
        ttk.Label(dialog, text="First Name:").grid(row=0, column=0, padx=5, pady=5)
        first_name_entry = ttk.Entry(dialog, width=30)
        first_name_entry.grid(row=0, column=1, padx=5, pady=5)
        
        ttk.Label(dialog, text="Last Name:").grid(row=1, column=0, padx=5, pady=5)
        last_name_entry = ttk.Entry(dialog, width=30)
        last_name_entry.grid(row=1, column=1, padx=5, pady=5)
        
        ttk.Label(dialog, text="Email:").grid(row=2, column=0, padx=5, pady=5)
        email_entry = ttk.Entry(dialog, width=30)
        email_entry.grid(row=2, column=1, padx=5, pady=5)
        
        ttk.Label(dialog, text="Type:").grid(row=3, column=0, padx=5, pady=5)
        type_var = StringVar(value="STUDENT")
        type_combo = ttk.Combobox(dialog, textvariable=type_var, values=["STUDENT", "PROFESSOR", "RESEARCHER"])
        type_combo.grid(row=3, column=1, padx=5, pady=5)
        
        def save_user():
            try:
                user = User(
                    id=str(uuid.uuid4()),
                    first_name=first_name_entry.get(),
                    last_name=last_name_entry.get(),
                    email=email_entry.get(),
                    user_type=type_var.get()
                )
                self.controller.add_user(user)
                self._load_users()
                dialog.destroy()
                messagebox.showinfo("Success", "User added successfully")
            except Exception as e:
                messagebox.showerror("Error", str(e))
        
        save_btn = ttk.Button(dialog, text="Save", command=save_user)
        save_btn.grid(row=4, column=0, columnspan=2, pady=20)
    
    def _delete_book(self):
        selection = self.book_tree.selection()
        if not selection:
            messagebox.showwarning("Warning", "Select a book to delete")
            return
        
        item = self.book_tree.item(selection[0])
        book_id = item['values'][0]
        
        if messagebox.askyesno("Confirm", "Delete this book?"):
            self.controller.remove(book_id)
            self._load_books()
    
    def _delete_user(self):
        selection = self.user_tree.selection()
        if not selection:
            messagebox.showwarning("Warning", "Select a user to delete")
            return
        
        item = self.user_tree.item(selection[0])
        user_id = item['values'][0]
        
        if messagebox.askyesno("Confirm", "Delete this user?"):
            self.controller.remove_user(user_id)
            self._load_users()
    
    def _create_loan(self):
        user_id = self.user_id_entry.get().strip()
        book_id = self.book_id_entry.get().strip()
        
        if not user_id or not book_id:
            messagebox.showwarning("Warning", "Please enter both IDs")
            return
        
        try:
            self.controller.create_loan(user_id, book_id)
            messagebox.showinfo("Success", "Loan created successfully")
            self.user_id_entry.delete(0, tk.END)
            self.book_id_entry.delete(0, tk.END)
            self._load_loans()
            self._load_books()
        except Exception as e:
            messagebox.showerror("Error", str(e))
    
    def _return_loan(self):
        loan_id = simpledialog.askstring("Return Book", "Enter Loan ID to return:")
        if loan_id:
            try:
                self.controller.return_loan(loan_id.strip())
                messagebox.showinfo("Success", "Book returned successfully")
                self._load_loans()
                self._load_books()
            except Exception as e:
                messagebox.showerror("Error", str(e))
    
    def _load_books(self):
        for item in self.book_tree.get_children():
            self.book_tree.delete(item)
        
        for book in self.controller.find_all():
            self.book_tree.insert("", tk.END, values=(
                book.id,
                book.title,
                book.author,
                book.isbn,
                book.publication_year,
                "Available" if book.available else "Borrowed",
                book.category
            ))
    
    def _load_users(self):
        for item in self.user_tree.get_children():
            self.user_tree.delete(item)
        
        for user in self.controller.find_all_users():
            self.user_tree.insert("", tk.END, values=(
                user.id,
                user.first_name,
                user.last_name,
                user.email,
                user.user_type,
                user.active_loans
            ))
    
    def _load_loans(self):
        for item in self.loan_tree.get_children():
            self.loan_tree.delete(item)
        
        for loan in self.controller.find_all_loans():
            self.loan_tree.insert("", tk.END, values=(
                loan.id,
                loan.user_id,
                loan.book_id,
                loan.loan_date.strftime("%Y-%m-%d %H:%M"),
                loan.status,
                f"${loan.fine:.2f}"
            ))
    
    def _update_statistics(self):
        self.total_books_label.config(text=f"Total Books: {self.controller.get_total_books()}")
        self.available_books_label.config(text=f"Available Books: {self.controller.get_available_books_count()}")
        self.total_users_label.config(text=f"Total Users: {self.controller.get_total_users()}")
        self.active_loans_label.config(text=f"Active Loans: {self.controller.get_active_loans_count()}")
    
    def _load_data(self):
        self._load_books()
        self._load_users()
        self._load_loans()
        self._update_statistics()
    
    def _exit_app(self):
        if messagebox.askyesno("Confirm", "Are you sure you want to exit?"):
            self.root.quit()
    
    def _show_about(self):
        messagebox.showinfo("About", 
            "Library Management System\nVersion: 1.0\nDeveloped for ESPE\n2024 All Rights Reserved")