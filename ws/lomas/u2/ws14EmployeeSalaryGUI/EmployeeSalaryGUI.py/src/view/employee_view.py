import tkinter as tk
from tkinter import messagebox, ttk
import customtkinter as ctk
from src.model.employee_model import EmployeeModel

ctk.set_appearance_mode("Light")
ctk.set_default_color_theme("green")

class EmployeeView(ctk.CTk):
    def __init__(self):
        super().__init__()

        self.model = EmployeeModel()
        self.model.load_from_file()

       
        self.title("Employee Payroll & Registration")
        self.geometry("750x760")
        self.configure(fg_color="#FFFFFF")  

        
        lbl_main_title = ctk.CTkLabel(
            self, text="Employee Payroll & Registration", 
            font=("Arial", 24, "bold"), text_color="#111111", anchor="w"
        )
        lbl_main_title.pack(fill="x", padx=25, pady=(20, 10))

     
        self.create_label("Employee ID (Alphanumeric):")
        self.txt_id = self.create_entry()

        self.create_label("Full Name (Letters only):")
        self.txt_name = self.create_entry()

        self.create_label("Clock-In Time:")
        self.txt_clock_in = self.create_entry(placeholder="--:--")

        self.create_label("Clock-Out Time:")
        self.txt_clock_out = self.create_entry(placeholder="--:--")

        self.create_label("Role / Position:")
        self.txt_role = self.create_entry()

        self.create_label("Salary ($):")
        self.txt_salary = self.create_entry()

       
        self.btn_register = ctk.CTkButton(
            self, text="Register Employee", font=("Arial", 14, "bold"),
            fg_color="#28a745", hover_color="#218838", text_color="#FFFFFF",
            corner_radius=4, height=40, command=self.handle_registration
        )
        self.btn_register.pack(fill="x", padx=25, pady=15)

        lbl_list_title = ctk.CTkLabel(
            self, text="Employee Payroll List", 
            font=("Arial", 18, "bold"), text_color="#111111", anchor="w"
        )
        lbl_list_title.pack(fill="x", padx=25, pady=(10, 5))

        
        style = ttk.Style()
        style.theme_use("default")
        style.configure("Treeview", background="#FFFFFF", fieldbackground="#FFFFFF", rowheight=30, font=("Arial", 11), borderwidth=0)
        style.configure("Treeview.Heading", background="#F2F2F2", foreground="#000000", font=("Arial", 11, "bold"), borderwidth=1)
        style.map("Treeview.Heading", background=[('active', '#E6E6E6')])

        table_frame = tk.Frame(self, bg="#FFFFFF")
        table_frame.pack(fill="both", expand=True, padx=25, pady=5)

        columns = ("ID", "Name", "Clock-In", "Clock-Out", "Role", "Salary")
        self.table = ttk.Treeview(table_frame, columns=columns, show="headings")
        
        for col in columns:
            self.table.heading(col, text=col, anchor="w")
            self.table.column(col, width=110, anchor="w")

        self.table.pack(fill="both", expand=True)

       
        self.total_panel = tk.Frame(self, bg="#E2E3E5", height=45)
        self.total_panel.pack(fill="x", padx=25, pady=(10, 25))
        self.total_panel.pack_propagate(False)

        self.lbl_total_budget = tk.Label(
            self.total_panel, text="TOTAL BUDGET REQUIRED: $0.00", 
            font=("Arial", 13, "bold"), bg="#E2E3E5", fg="#000000"
        )
        self.lbl_total_budget.pack(side="left", padx=15, pady=10)

        
        self.update_ui()

    def create_label(self, text):
        lbl = ctk.CTkLabel(self, text=text, font=("Arial", 13, "bold"), text_color="#000000", anchor="w")
        lbl.pack(fill="x", padx=25, pady=(4, 2))
        return lbl

    def create_entry(self, placeholder=""):
        entry = ctk.CTkEntry(
            self, placeholder_text=placeholder, height=35,
            fg_color="#FFFFFF", text_color="#000000",
            border_color="#CCCCCC", border_width=1, corner_radius=4
        )
        entry.pack(fill="x", padx=25, pady=(0, 6))
        return entry

    def update_ui(self):
        
        for item in self.table.get_children():
            self.table.delete(item)

        
        for emp in self.model.get_employees():
            self.table.insert("", "end", values=(
                emp.id, emp.name, emp.clock_in, emp.clock_out, emp.role, f"${emp.salary:.2f}"
            ))

        
        total = self.model.calculate_total_salaries()
        self.lbl_total_budget.config(text=f"TOTAL BUDGET REQUIRED: ${total:.2f}")

    def handle_registration(self):
        id_val = self.txt_id.get().strip()
        name_val = self.txt_name.get().strip()
        clock_in_val = self.txt_clock_in.get().strip()
        clock_out_val = self.txt_clock_out.get().strip()
        role_val = self.txt_role.get().strip()
        salary_str = self.txt_salary.get().strip()

        if not (id_val and name_val and clock_in_val and clock_out_val and role_val and salary_str):
            messagebox.showerror("Error", "All fields are required.")
            return

        try:
            salary_val = float(salary_str)
            if salary_val < 0:
                messagebox.showerror("Error", "Please enter a valid positive salary amount.")
                return
        except ValueError:
            messagebox.showerror("Error", "Salary must be a valid numeric value.")
            return

        self.model.add_employee(id_val, name_val, clock_in_val, clock_out_val, role_val, salary_val)

        if self.model.save_to_file():
            messagebox.showinfo("Success", "Employee saved successfully to JSON!")
            
            
            self.txt_id.delete(0, tk.END)
            self.txt_name.delete(0, tk.END)
            self.txt_clock_in.delete(0, tk.END)
            self.txt_clock_out.delete(0, tk.END)
            self.txt_role.delete(0, tk.END)
            self.txt_salary.delete(0, tk.END)
            
            self.update_ui()
        else:
            messagebox.showerror("Error", "Error saving employee data.")