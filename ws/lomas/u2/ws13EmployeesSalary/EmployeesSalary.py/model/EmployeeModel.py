import json
import os
from model.Employee import Employee

class EmployeeModel:
    def __init__(self):
        
        self.file_path = os.path.join(os.path.dirname(__file__), "employees.json")
        self.employees = [] # Nuestro "ArrayList" en Python

    def add_employee(self, employee_id, name, salary):
        new_employee = Employee(employee_id, name, salary)
        self.employees.append(new_employee)

    def save_to_file(self):
        try:
           
            data_to_save = [
                {"id": emp.id, "name": emp.name, "salary": emp.salary} 
                for emp in self.employees
            ]
            with open(self.file_path, "w", encoding="utf-8") as f:
                json.dump(data_to_save, f, indent=4)
            return True
        except Exception as e:
            print(f"[ERROR]: Could not save file: {e}")
            return False

    def calculate_total_salaries(self):
        return sum(emp.salary for emp in self.employees)

    def get_employees(self):
        return self.employees