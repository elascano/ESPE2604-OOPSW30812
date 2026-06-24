import tkinter as tk
from tkinter import messagebox

from model.student import Student
from controller.student_controller import StudentController


class StudentView:

    def __init__(self, root):

        self.controller = StudentController()

        self.root = root
        self.root.title("Students CRUD MVC")
        self.root.geometry("700x500")

        tk.Label(root, text="ID").grid(row=0, column=0, padx=10, pady=10)

        self.txt_id = tk.Entry(root)
        self.txt_id.grid(row=0, column=1)

        tk.Label(root, text="Name").grid(row=1, column=0)

        self.txt_name = tk.Entry(root)
        self.txt_name.grid(row=1, column=1)

        tk.Label(root, text="Grade 1").grid(row=2, column=0)

        self.txt_grade1 = tk.Entry(root)
        self.txt_grade1.grid(row=2, column=1)

        tk.Label(root, text="Grade 2").grid(row=3, column=0)

        self.txt_grade2 = tk.Entry(root)
        self.txt_grade2.grid(row=3, column=1)

        tk.Button(
            root,
            text="Create",
            command=self.create_student
        ).grid(row=4, column=0)

        tk.Button(
            root,
            text="Find",
            command=self.find_student
        ).grid(row=4, column=1)

        tk.Button(
            root,
            text="Update",
            command=self.update_student
        ).grid(row=4, column=2)

        tk.Button(
            root,
            text="Delete",
            command=self.delete_student
        ).grid(row=4, column=3)

        tk.Button(
            root,
            text="List All",
            command=self.list_students
        ).grid(row=4, column=4)

        self.text_area = tk.Text(root, width=80, height=15)
        self.text_area.grid(
            row=5,
            column=0,
            columnspan=5,
            padx=10,
            pady=20
        )

    def create_student(self):

        try:
            student = Student(
                int(self.txt_id.get()),
                self.txt_name.get(),
                float(self.txt_grade1.get()),
                float(self.txt_grade2.get())
            )

            self.controller.create_student(student)

            messagebox.showinfo(
                "Success",
                "Student created"
            )

        except ValueError:
            messagebox.showerror(
                "Error",
                "Invalid data"
            )

    def find_student(self):

        self.text_area.delete(1.0, tk.END)

        student = self.controller.find_student(
            int(self.txt_id.get())
        )

        if student:
            self.text_area.insert(tk.END, str(student))
        else:
            self.text_area.insert(
                tk.END,
                "Student not found"
            )

    def update_student(self):

        updated = self.controller.update_student(
            int(self.txt_id.get()),
            self.txt_name.get(),
            float(self.txt_grade1.get()),
            float(self.txt_grade2.get())
        )

        if updated:
            messagebox.showinfo(
                "Success",
                "Student updated"
            )
        else:
            messagebox.showerror(
                "Error",
                "Student not found"
            )

    def delete_student(self):

        deleted = self.controller.delete_student(
            int(self.txt_id.get())
        )

        if deleted:
            messagebox.showinfo(
                "Success",
                "Student deleted"
            )
        else:
            messagebox.showerror(
                "Error",
                "Student not found"
            )

    def list_students(self):

        self.text_area.delete(1.0, tk.END)

        for student in self.controller.get_all_students():
            self.text_area.insert(
                tk.END,
                str(student) + "\n"
            )