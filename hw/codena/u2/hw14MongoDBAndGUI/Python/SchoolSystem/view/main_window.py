import tkinter as tk

from tkinter import ttk
from tkinter import messagebox

from controller.student_controller import StudentController
from controller.teacher_controller import TeacherController
from controller.course_controller import CourseController

from model.student import Student
from model.teacher import Teacher
from model.course import Course

class MainWindow:

    def __init__(self):

        self.student_controller = StudentController()
        self.teacher_controller = TeacherController()
        self.course_controller = CourseController()

        self.window = tk.Tk()

        self.window.title("School System")
        self.window.geometry("1000x700")

        self.create_student_section()
        self.create_course_section()
        self.create_teacher_section()

        self.window.mainloop()

# Student Interface

    def create_student_section(self):

        frame = ttk.LabelFrame(
            self.window,
            text="Student Management"
        )

        frame.pack(
            fill="x",
            padx=10,
            pady=10
        )

        ttk.Label(frame, text="Id").grid(row=0, column=0, padx=10, pady=5)

        self.txt_student_id = ttk.Entry(frame, width=30)
        self.txt_student_id.grid(row=0, column=1)

        ttk.Label(frame, text="First Name").grid(row=1, column=0)

        self.txt_first_name = ttk.Entry(frame, width=30)
        self.txt_first_name.grid(row=1, column=1)

        ttk.Label(frame, text="Last Name").grid(row=2, column=0)

        self.txt_last_name = ttk.Entry(frame, width=30)
        self.txt_last_name.grid(row=2, column=1)

        ttk.Label(frame, text="Age").grid(row=3, column=0)

        self.txt_age = ttk.Entry(frame, width=30)
        self.txt_age.grid(row=3, column=1)

        ttk.Button(
            frame,
            text="Save",
            command=self.save_student
        ).grid(row=0, column=2, padx=20)

        ttk.Button(
            frame,
            text="Search",
            command=self.search_student
        ).grid(row=1, column=2)

        ttk.Button(
            frame,
            text="Update",
            command=self.update_student
        ).grid(row=2, column=2)

        ttk.Button(
            frame,
            text="Delete",
            command=self.delete_student
        ).grid(row=3, column=2)

    def save_student(self):

        student = Student(

            self.txt_student_id.get(),

            self.txt_first_name.get(),

            self.txt_last_name.get(),

            int(self.txt_age.get())
        )

        self.student_controller.save_student(student)

        messagebox.showinfo(
            "Success",
            "Student saved"
        )

    def search_student(self):

        student = self.student_controller.search_student(
            self.txt_student_id.get()
        )

        if student:

            self.txt_first_name.delete(0, tk.END)
            self.txt_last_name.delete(0, tk.END)
            self.txt_age.delete(0, tk.END)

            self.txt_first_name.insert(
                0,
                student["firstName"]
            )

            self.txt_last_name.insert(
                0,
                student["lastName"]
            )

            self.txt_age.insert(
                0,
                str(student["age"])
            )

        else:

            messagebox.showwarning(
                "Not Found",
                "Student not found"
            )

    def update_student(self):

        student = Student(

            self.txt_student_id.get(),

            self.txt_first_name.get(),

            self.txt_last_name.get(),

            int(self.txt_age.get())
        )

        self.student_controller.update_student(
            student
        )

        messagebox.showinfo(
            "Success",
            "Student updated"
        )

    def delete_student(self):

        self.student_controller.delete_student(
            self.txt_student_id.get()
        )

        messagebox.showinfo(
            "Success",
            "Student deleted"
        )

# Teacher Interface

    def create_teacher_section(self):

        frame = ttk.LabelFrame(self.window, text="Teacher Management")

        frame.pack(fill="x", padx=10, pady=10)

        ttk.Label(frame, text="Id").grid(row=0, column=0, padx=10, pady=5)

        self.txt_teacher_id = ttk.Entry(frame, width=30)
        self.txt_teacher_id.grid(row=0, column=1)

        ttk.Label(frame, text="Name").grid(row=1, column=0)

        self.txt_name = ttk.Entry(frame, width=30)
        self.txt_name.grid(row=1, column=1)

        ttk.Label(frame, text="Subject").grid(row=2, column=0)

        self.txt_subject = ttk.Entry(frame, width=30)
        self.txt_subject.grid(row=2, column=1)

        ttk.Button(
            frame,
            text="Save",
            command=self.save_teacher
        ).grid(row=0, column=2, padx=20)

        ttk.Button(
            frame,
            text="Search",
            command=self.search_teacher
        ).grid(row=1, column=2)

        ttk.Button(
            frame,
            text="Update",
            command=self.update_teacher
        ).grid(row=2, column=2)

        ttk.Button(
            frame,
            text="Delete",
            command=self.delete_teacher
        ).grid(row=3, column=2)


    def save_teacher(self):

        teacher = Teacher(self.txt_teacher_id.get(), self.txt_name.get(), self.txt_subject.get())
        self.teacher_controller.save_teacher(teacher)

        messagebox.showinfo("Success","Teacher saved")

    def search_teacher(self):

        teacher = self.teacher_controller.search_teacher(self.txt_teacher_id.get())

        if teacher:

            self.txt_name.delete(0, tk.END)
            self.txt_subject.delete(0, tk.END)
            self.txt_name.insert(0,teacher["name"])
            self.txt_subject.insert(0,teacher["subject"])

        else:

            messagebox.showwarning("Not Found", "Teacher not found")

    def update_teacher(self):

        teacher = Teacher(self.txt_teacher_id.get(), self.txt_name.get(), self.txt_subject.get())
        self.teacher_controller.update_teacher(teacher)

        messagebox.showinfo("Success", "Teacher updated")

    def delete_teacher(self):

        self.teacher_controller.delete_teacher(self.txt_teacher_id.get())

        messagebox.showinfo("Success", "Teacher deleted")

# Course Interface

    def create_course_section(self):

        frame = ttk.LabelFrame(self.window, text="Course Management")

        frame.pack(fill="x", padx=10, pady=10)

        ttk.Label(frame, text="Id").grid(row=0, column=0, padx=10, pady=5)

        self.txt_course_id = ttk.Entry(frame, width=30)
        self.txt_course_id.grid(row=0, column=1)

        ttk.Label(frame, text="Name").grid(row=1, column=0)

        self.txt_course_name = ttk.Entry(frame, width=30)
        self.txt_course_name.grid(row=1, column=1)

        ttk.Label(frame, text="Teacher").grid(row=2, column=0)

        self.txt_teacher = ttk.Entry(frame, width=30)
        self.txt_teacher.grid(row=2, column=1)

        ttk.Button(
            frame,
            text="Save",
            command=self.save_course
        ).grid(row=0, column=2, padx=20)

        ttk.Button(
            frame,
            text="Search",
            command=self.search_course
        ).grid(row=1, column=2)

        ttk.Button(
            frame,
            text="Update",
            command=self.update_course
        ).grid(row=2, column=2)

        ttk.Button(
            frame,
            text="Delete",
            command=self.delete_course
        ).grid(row=3, column=2)


    def save_course(self):

        course = Course(self.txt_course_id.get(), self.txt_course_name.get(), self.txt_teacher.get())
        self.course_controller.save_course(course)

        messagebox.showinfo("Success","Course saved")

    def search_course(self):

        course = self.course_controller.search_course(self.txt_course_id.get())

        if course:

            self.txt_course_name.delete(0, tk.END)
            self.txt_teacher.delete(0, tk.END)
            self.txt_course_name.insert(0,course["name"])
            self.txt_teacher.insert(0,course["teacher"])

        else:

            messagebox.showwarning("Not Found", "Course not found")

    def update_course(self):

        course = Course(self.txt_course_id.get(), self.txt_course_name.get(), self.txt_teacher.get())
        self.course_controller.update_course(course)

        messagebox.showinfo("Success", "Course updated")

    def delete_course(self):

        self.course_controller.delete_course(self.txt_course_id.get())

        messagebox.showinfo("Success", "Course deleted")



