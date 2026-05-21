# view/student_gui.py

import tkinter as tk
from tkinter import ttk, messagebox, simpledialog
import sys
import os

# Add parent directory to path to import models
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from model.student import Student
from model.json_manager import JsonManager


class StudentsApplication:
    """Main GUI Application for Student Management System"""
    
    def __init__(self, root):
        self.root = root
        self.students = []
        self.temp_subjects_grades = {}
        self.selected_row = None
        self.current_subject = None
        
        self.setup_ui()
        self.load_data()
    
    def setup_ui(self):
        """Setup the main user interface"""
        self.root.title("📚 Student Management System - Decimal Grades Supported")
        self.root.geometry("1200x750")
        self.root.configure(bg="#f0f0f0")
        
        # Main container
        main_frame = ttk.Frame(self.root)
        main_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Header
        self.setup_header(main_frame)
        
        # Notebook (tabs)
        self.notebook = ttk.Notebook(main_frame)
        self.notebook.pack(fill=tk.BOTH, expand=True, pady=10)
        
        # Tab 1: Student List
        self.setup_list_tab()
        
        # Tab 2: Quick Add
        self.setup_add_tab()
        
        # Status bar
        self.status_bar = ttk.Label(main_frame, text="Ready", relief=tk.SUNKEN, anchor=tk.W)
        self.status_bar.pack(fill=tk.X, side=tk.BOTTOM)
    
    def setup_header(self, parent):
        """Setup header with title and main buttons"""
        header_frame = ttk.Frame(parent)
        header_frame.pack(fill=tk.X, pady=(0, 10))
        
        # Title
        title = tk.Label(header_frame, text="STUDENT MANAGEMENT SYSTEM", 
                        font=("Arial", 20, "bold"), fg="#003366", bg="#f0f0f0")
        title.pack(pady=10)
        
        # Main buttons
        button_frame = tk.Frame(header_frame, bg="#f0f0f0")
        button_frame.pack(pady=10)
        
        btn_add = tk.Button(button_frame, text="➕ ADD STUDENT", bg="#2ecc71", fg="white",
                           font=("Arial", 12, "bold"), padx=20, pady=10,
                           command=self.show_add_tab)
        btn_add.pack(side=tk.LEFT, padx=5)
        
        btn_reload = tk.Button(button_frame, text="🔄 RELOAD DATA", bg="#3498db", fg="white",
                              font=("Arial", 12, "bold"), padx=20, pady=10,
                              command=self.reload_data)
        btn_reload.pack(side=tk.LEFT, padx=5)
        
        btn_average = tk.Button(button_frame, text="📊 SHOW AVERAGES", bg="#e67e22", fg="white",
                               font=("Arial", 12, "bold"), padx=20, pady=10,
                               command=self.show_average_dialog)
        btn_average.pack(side=tk.LEFT, padx=5)
        
        btn_exit = tk.Button(button_frame, text="❌ EXIT", bg="#e74c3c", fg="white",
                            font=("Arial", 12, "bold"), padx=20, pady=10,
                            command=self.root.quit)
        btn_exit.pack(side=tk.LEFT, padx=5)
    
    def setup_list_tab(self):
        """Setup the student list tab"""
        self.list_frame = ttk.Frame(self.notebook)
        self.notebook.add(self.list_frame, text="📋 Student List")
        
        # Control buttons
        control_frame = ttk.Frame(self.list_frame)
        control_frame.pack(fill=tk.X, pady=5)
        
        btn_refresh = tk.Button(control_frame, text="🔄 Refresh Table", 
                               command=self.load_student_table)
        btn_refresh.pack(side=tk.LEFT, padx=5)
        
        btn_delete = tk.Button(control_frame, text="🗑️ Delete Selected", 
                              bg="#e74c3c", fg="white", command=self.delete_selected_student)
        btn_delete.pack(side=tk.LEFT, padx=5)
        
        # Treeview (table)
        columns = ("First Name", "Last Name", "Age", "Subjects", "Average")
        self.tree = ttk.Treeview(self.list_frame, columns=columns, show="headings", height=15)
        
        for col in columns:
            self.tree.heading(col, text=col)
            self.tree.column(col, width=150)
        
        scrollbar = ttk.Scrollbar(self.list_frame, orient=tk.VERTICAL, command=self.tree.yview)
        self.tree.configure(yscrollcommand=scrollbar.set)
        
        self.tree.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        
        self.tree.bind("<<TreeviewSelect>>", self.on_tree_select)
    
    def setup_add_tab(self):
        """Setup the quick add tab"""
        self.add_frame = ttk.Frame(self.notebook)
        self.notebook.add(self.add_frame, text="➕ Quick Add")
        
        # Form frame
        form_frame = ttk.LabelFrame(self.add_frame, text="Student Information", padding=10)
        form_frame.pack(fill=tk.X, pady=10, padx=10)
        
        # First Name
        ttk.Label(form_frame, text="First Name:").grid(row=0, column=0, sticky=tk.W, pady=5)
        self.txt_first_name = ttk.Entry(form_frame, width=30)
        self.txt_first_name.grid(row=0, column=1, pady=5, padx=10)
        
        # Last Name
        ttk.Label(form_frame, text="Last Name:").grid(row=1, column=0, sticky=tk.W, pady=5)
        self.txt_last_name = ttk.Entry(form_frame, width=30)
        self.txt_last_name.grid(row=1, column=1, pady=5, padx=10)
        
        # Age
        ttk.Label(form_frame, text="Age:").grid(row=2, column=0, sticky=tk.W, pady=5)
        self.txt_age = ttk.Entry(form_frame, width=30)
        self.txt_age.grid(row=2, column=1, pady=5, padx=10)
        
        # Subject selection
        ttk.Label(form_frame, text="Select Subject:").grid(row=3, column=0, sticky=tk.W, pady=5)
        self.cb_subjects = ttk.Combobox(form_frame, values=[
            "Mathematics", "Physics", "History", "Programming", 
            "English", "Chemistry", "Biology", "Language Arts",
            "Physical Education", "Arts"
        ], width=27)
        self.cb_subjects.grid(row=3, column=1, pady=5, padx=10)
        self.cb_subjects.set("Mathematics")
        
        btn_add_subject = tk.Button(form_frame, text="➕ ADD SUBJECT WITH GRADES", 
                                    bg="#2ecc71", fg="white", command=self.show_grade_dialog)
        btn_add_subject.grid(row=3, column=2, padx=10)
        
        # Subjects list frame
        subjects_frame = ttk.LabelFrame(self.add_frame, text="Subjects and Grades", padding=10)
        subjects_frame.pack(fill=tk.BOTH, expand=True, pady=10, padx=10)
        
        # Listbox with scrollbar
        list_frame = ttk.Frame(subjects_frame)
        list_frame.pack(fill=tk.BOTH, expand=True)
        
        scrollbar = ttk.Scrollbar(list_frame)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        
        self.subject_listbox = tk.Listbox(list_frame, yscrollcommand=scrollbar.set, height=8)
        self.subject_listbox.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        scrollbar.config(command=self.subject_listbox.yview)
        
        self.subject_listbox.bind("<<ListboxSelect>>", self.on_subject_select)
        
        btn_remove_subject = tk.Button(subjects_frame, text="❌ Remove Selected Subject",
                                       bg="#f39c12", fg="white", command=self.remove_selected_subject)
        btn_remove_subject.pack(pady=5)
        
        # Action buttons
        action_frame = ttk.Frame(self.add_frame)
        action_frame.pack(fill=tk.X, pady=10, padx=10)
        
        btn_save = tk.Button(action_frame, text="💾 SAVE STUDENT", bg="#3498db", fg="white",
                            font=("Arial", 12, "bold"), padx=20, pady=10, command=self.save_quick_student)
        btn_save.pack(side=tk.LEFT, padx=5)
        
        btn_clear = tk.Button(action_frame, text="🗑️ Clear Form", bg="#95a5a6", fg="white",
                             font=("Arial", 12, "bold"), padx=20, pady=10, command=self.clear_quick_form)
        btn_clear.pack(side=tk.LEFT, padx=5)
    
    def parse_grade(self, value):
        """Parse grade value (accepts integers and decimals)"""
        value = value.strip().replace(',', '.')
        grade = float(value)
        if grade < 0 or grade > 20:
            raise ValueError("Grade out of range (0-20)")
        return round(grade * 100) / 100
    
    def show_grade_dialog(self):
        """Show dialog to enter grades for a subject"""
        subject = self.cb_subjects.get()
        self.current_subject = subject
        
        dialog = tk.Toplevel(self.root)
        dialog.title(f"📝 Enter grades for {subject}")
        dialog.geometry("450x350")
        dialog.transient(self.root)
        dialog.grab_set()
        dialog.configure(bg="#f0f0f0")
        
        # Instructions
        tk.Label(dialog, text=f"Enter grades for {subject}", 
                font=("Arial", 12, "bold"), bg="#f0f0f0").pack(pady=10)
        tk.Label(dialog, text="Accepts: integers (15) or decimals (15.75)", 
                bg="#f0f0f0", fg="#666").pack()
        
        # Grade entries
        self.grade_entries = []
        grades_frame = tk.Frame(dialog, bg="#f0f0f0")
        grades_frame.pack(pady=20)
        
        for i in range(3):
            frame = tk.Frame(grades_frame, bg="#f0f0f0")
            frame.pack(pady=5)
            tk.Label(frame, text=f"Grade {i+1}:", width=10, anchor=tk.W, 
                    bg="#f0f0f0").pack(side=tk.LEFT, padx=5)
            entry = tk.Entry(frame, width=15)
            entry.pack(side=tk.LEFT)
            self.grade_entries.append(entry)
        
        # Examples
        tk.Label(dialog, text="Examples: 15 | 18.5 | 20 | 7.75 | 0", 
                bg="#f0f0f0", fg="gray").pack(pady=10)
        
        # Message label for errors
        self.grade_message = tk.Label(dialog, text="", bg="#f0f0f0", fg="red")
        self.grade_message.pack()
        
        # Buttons
        button_frame = tk.Frame(dialog, bg="#f0f0f0")
        button_frame.pack(pady=20)
        
        tk.Button(button_frame, text="💾 SAVE GRADES", bg="#2ecc71", fg="white",
                 font=("Arial", 10, "bold"), padx=15, pady=5,
                 command=lambda: self.save_grades(dialog)).pack(side=tk.LEFT, padx=10)
        
        tk.Button(button_frame, text="CANCEL", bg="#e74c3c", fg="white",
                 font=("Arial", 10, "bold"), padx=15, pady=5,
                 command=dialog.destroy).pack(side=tk.LEFT, padx=10)
    
    def save_grades(self, dialog):
        """Save grades from dialog"""
        try:
            grades = []
            for entry in self.grade_entries:
                grade = self.parse_grade(entry.get())
                grades.append(grade)
            
            self.temp_subjects_grades[self.current_subject] = grades
            self.update_subject_list()
            dialog.destroy()
            self.update_status_message(f"✅ Grades saved for {self.current_subject}")
            messagebox.showinfo("Success", f"✅ Grades saved for {self.current_subject}\n\nGrades: {grades}")
        
        except ValueError as e:
            self.grade_message.config(text=f"❌ {str(e)} | Use: 15 (integer) or 15.5 (decimal)")
    
    def update_subject_list(self):
        """Update the subject listbox with temporary subjects"""
        self.subject_listbox.delete(0, tk.END)
        for subject, grades in self.temp_subjects_grades.items():
            self.subject_listbox.insert(tk.END, f"{subject} → {grades}")
    
    def on_subject_select(self, event):
        """Handle subject selection in listbox"""
        selection = self.subject_listbox.curselection()
        self.selected_subject_index = selection[0] if selection else None
    
    def remove_selected_subject(self):
        """Remove selected subject from temporary list"""
        if hasattr(self, 'selected_subject_index') and self.selected_subject_index is not None:
            subjects = list(self.temp_subjects_grades.keys())
            if self.selected_subject_index < len(subjects):
                subject = subjects[self.selected_subject_index]
                del self.temp_subjects_grades[subject]
                self.update_subject_list()
                self.selected_subject_index = None
                self.update_status_message(f"Removed: {subject}")
    
    def save_quick_student(self):
        """Save student with temporary subjects and grades"""
        first_name = self.txt_first_name.get().strip()
        last_name = self.txt_last_name.get().strip()
        
        if not first_name or not last_name:
            messagebox.showerror("Error", "Please enter first and last name")
            return
        
        try:
            age = int(self.txt_age.get())
            if age < 0 or age > 120:
                raise ValueError
        except ValueError:
            messagebox.showerror("Error", "Age must be between 0 and 120")
            return
        
        if not self.temp_subjects_grades:
            messagebox.showwarning("Warning", "Add at least one subject with grades")
            return
        
        # Create student
        student = Student(first_name, last_name, age, self.temp_subjects_grades.copy())
        self.students.append(student)
        
        # Save to JSON
        JsonManager.save_students(self.students)
        
        # Refresh UI
        self.load_student_table()
        self.clear_quick_form()
        self.update_status_message("🎉 Student saved successfully!")
        
        messagebox.showinfo("Success", 
            f"🎉 Student saved successfully!\n\n"
            f"Name: {first_name} {last_name}\n"
            f"Subjects: {len(self.temp_subjects_grades)}\n"
            f"Overall Average: {student.get_overall_average():.2f}"
        )
        
        if messagebox.askyesno("Success", "View in list?"):
            self.notebook.select(0)
    
    def clear_quick_form(self):
        """Clear all form fields and temporary data"""
        self.txt_first_name.delete(0, tk.END)
        self.txt_last_name.delete(0, tk.END)
        self.txt_age.delete(0, tk.END)
        self.temp_subjects_grades.clear()
        self.update_subject_list()
        self.update_status_message("Form cleared")
    
    def load_student_table(self):
        """Load students into the table"""
        # Clear existing items
        for item in self.tree.get_children():
            self.tree.delete(item)
        
        # Add students to table
        for student in self.students:
            subjects = ", ".join(student.get_subject_names())
            avg = student.get_overall_average()
            
            self.tree.insert("", tk.END, values=(
                student.first_name,
                student.last_name,
                student.age,
                subjects if subjects else "No subjects",
                f"{avg:.2f}"
            ))
        
        self.update_status_bar()
    
    def on_tree_select(self, event):
        """Handle selection in treeview"""
        selection = self.tree.selection()
        if selection:
            self.selected_row = self.tree.index(selection[0])
        else:
            self.selected_row = None
    
    def delete_selected_student(self):
        """Delete selected student"""
        if self.selected_row is None:
            messagebox.showwarning("Warning", "Please select a student to delete")
            return
        
        student = self.students[self.selected_row]
        
        if messagebox.askyesno("Confirm Delete", 
                               f"Delete {student.first_name} {student.last_name}?"):
            del self.students[self.selected_row]
            JsonManager.save_students(self.students)
            self.load_student_table()
            self.selected_row = None
            self.update_status_message("🗑️ Student deleted successfully")
            messagebox.showinfo("Success", "Student deleted!")
    
    def show_average_dialog(self):
        """Show dialog with class averages report"""
        if not self.students:
            messagebox.showinfo("Info", "No students registered")
            return
        
        # Create dialog
        dialog = tk.Toplevel(self.root)
        dialog.title("📊 Class Averages Report")
        dialog.geometry("550x450")
        dialog.transient(self.root)
        dialog.grab_set()
        
        # Text area for report
        text_area = tk.Text(dialog, wrap=tk.WORD, font=("Courier", 10))
        text_area.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        # Build report
        report = "═" * 55 + "\n"
        report += "              CLASS AVERAGES REPORT\n"
        report += "═" * 55 + "\n\n"
        
        class_total = 0
        for student in self.students:
            avg = student.get_overall_average()
            class_total += avg
            report += f"📌 {student.first_name:15} {student.last_name:15} → {avg:6.2f}\n"
        
        report += "\n" + "═" * 55 + "\n"
        report += f"🏆 CLASS AVERAGE: {class_total / len(self.students):.2f}\n"
        report += "═" * 55 + "\n"
        
        text_area.insert(tk.END, report)
        text_area.config(state=tk.DISABLED)
        
        # Close button
        btn_close = tk.Button(dialog, text="CLOSE", bg="#3498db", fg="white",
                             font=("Arial", 10, "bold"), command=dialog.destroy)
        btn_close.pack(pady=10)
    
    def reload_data(self):
        """Reload data from JSON file"""
        self.load_data()
        self.update_status_message("🔄 Data reloaded from JSON file")
        messagebox.showinfo("Success", "✅ Data reloaded successfully!")
    
    def load_data(self):
        """Load students from JSON file"""
        self.students = JsonManager.read_students()
        self.load_student_table()
    
    def show_add_tab(self):
        """Switch to the add tab"""
        self.notebook.select(1)
        messagebox.showinfo("Info", 
            "Complete the form in the 'Quick Add' tab\n\n"
            "Add subjects and grades using the button.\n\n"
            "💡 Tip: You can use integers (15) or decimals (15.75)")
    
    def update_status_message(self, message):
        """Update status bar with message"""
        self.status_bar.config(text=f" {message} | Total students: {len(self.students)}")
    
    def update_status_bar(self):
        """Update status bar with default message"""
        self.status_bar.config(text=f" Ready | Total students: {len(self.students)} | Accepts integers (15) and decimals (15.5)")


def main():
    """Main entry point for the application"""
    root = tk.Tk()
    app = StudentsApplication(root)
    root.mainloop()


if __name__ == "__main__":
    main()