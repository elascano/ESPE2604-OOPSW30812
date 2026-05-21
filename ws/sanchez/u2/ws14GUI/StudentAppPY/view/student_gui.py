import sys
import os

# Agrega la carpeta padre al path de Python
sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

import tkinter as tk
from tkinter import ttk, messagebox
from model.student import Student
from model.json_manager import JsonManager

class StudentGUI:
    def __init__(self):
        self.manager = JsonManager()
        self.root = tk.Tk()
        self.root.title("Student Management System")
        self.root.geometry("950x500")
        self.root.resizable(False, False)

        # Form Panel
        form_frame = tk.LabelFrame(self.root, text="Student Entry", padx=10, pady=10)
        form_frame.pack(side=tk.LEFT, padx=10, pady=10, fill=tk.Y)

        tk.Label(form_frame, text="ID Number").grid(row=0, column=0, sticky=tk.W, pady=5)
        self.txt_id_number = tk.Entry(form_frame, width=30)
        self.txt_id_number.grid(row=0, column=1, pady=5)

        tk.Label(form_frame, text="Name").grid(row=1, column=0, sticky=tk.W, pady=5)
        self.txt_name = tk.Entry(form_frame, width=30)
        self.txt_name.grid(row=1, column=1, pady=5)

        tk.Label(form_frame, text="Age").grid(row=2, column=0, sticky=tk.W, pady=5)
        self.txt_age = tk.Entry(form_frame, width=30)
        self.txt_age.grid(row=2, column=1, pady=5)

        tk.Label(form_frame, text="Career").grid(row=3, column=0, sticky=tk.W, pady=5)
        self.cmb_career = ttk.Combobox(form_frame, values=[
            "Software Engineering",
            "Computer Science",
            "Business",
            "Medicine"
        ], width=27)
        self.cmb_career.grid(row=3, column=1, pady=5)
        self.cmb_career.current(0)

        tk.Label(form_frame, text="Grades (comma separated)").grid(row=4, column=0, sticky=tk.W, pady=5)
        self.txt_grades = tk.Entry(form_frame, width=30)
        self.txt_grades.grid(row=4, column=1, pady=5)

        btn_add = tk.Button(form_frame, text="Add Student", command=self.add_student, bg="green", fg="white")
        btn_add.grid(row=5, column=0, pady=10, padx=5)

        btn_clear = tk.Button(form_frame, text="Clear", command=self.clear_fields, bg="orange")
        btn_clear.grid(row=5, column=1, pady=10, padx=5)

        # Table Panel
        table_frame = tk.Frame(self.root)
        table_frame.pack(side=tk.RIGHT, padx=10, pady=10, fill=tk.BOTH, expand=True)

        columns = ("ID Number", "Name", "Age", "Career", "GPA")
        self.table = ttk.Treeview(table_frame, columns=columns, show="headings")

        for col in columns:
            self.table.heading(col, text=col)
            self.table.column(col, width=120)

        scrollbar = ttk.Scrollbar(table_frame, orient=tk.VERTICAL, command=self.table.yview)
        self.table.configure(yscrollcommand=scrollbar.set)

        self.table.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)

        self.load_table()
        self.root.mainloop()

    def add_student(self):
        try:
            id_number = self.txt_id_number.get().strip()
            name = self.txt_name.get().strip()
            age = int(self.txt_age.get().strip())
            career = self.cmb_career.get()

            grade_text = self.txt_grades.get().strip()
            grades = []
            for g in grade_text.split(','):
                value = float(g.strip())
                if value < 0 or value > 20:
                    raise ValueError("Grades must be 0-20")
                grades.append(value)

            if not id_number or not name or not grades:
                raise ValueError("Fields cannot be empty")

            student = Student(id_number, name, age, career, grades)
            self.manager.add_student(student)
            self.load_table()
            self.clear_fields()
            messagebox.showinfo("Success", "Student added successfully")

        except ValueError as e:
            messagebox.showerror("Error", str(e))

    def load_table(self):
        for row in self.table.get_children():
            self.table.delete(row)

        for s in self.manager.get_students():
            self.table.insert("", tk.END, values=(
                s.get_id_number(),
                s.get_name(),
                s.get_age(),
                s.get_career(),
                f"{s.calculate_gpa():.2f}"
            ))

    def clear_fields(self):
        self.txt_id_number.delete(0, tk.END)
        self.txt_name.delete(0, tk.END)
        self.txt_age.delete(0, tk.END)
        self.txt_grades.delete(0, tk.END)
        self.cmb_career.current(0)

if __name__ == "__main__":
    StudentGUI()