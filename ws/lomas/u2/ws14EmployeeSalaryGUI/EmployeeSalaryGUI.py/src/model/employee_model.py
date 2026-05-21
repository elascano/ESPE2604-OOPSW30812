import json
import os

class Employee:
    def __init__(self, emp_id, name, clock_in, clock_out, role, salary):
        self.id = emp_id
        self.name = name
        self.clock_in = clock_in
        self.clock_out = clock_out
        self.role = role
        self.salary = float(salary)

    
    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "clock_in": self.clock_in,
            "clock_out": self.clock_out,
            "role": self.role,
            "salary": self.salary
        }


class EmployeeModel:
    def __init__(self, file_path="employees.json"):
        self.file_path = file_path
        self.employees = []

    def add_employee(self, emp_id, name, clock_in, clock_out, role, salary):
        new_emp = Employee(emp_id, name, clock_in, clock_out, role, salary)
        self.employees.append(new_emp)

    def save_to_file(self):
        try:
            data = [emp.to_dict() for emp in self.employees]
            with open(self.file_path, 'w', encoding='utf-8') as f:
                json.dump(data, f, indent=4, ensure_ascii=False)
            return True
        except Exception as e:
            print(f"Error saving data: {e}")
            return False

    def load_from_file(self):
        if not os.path.exists(self.file_path):
            self.employees = []
            return
        try:
            with open(self.file_path, 'r', encoding='utf-8') as f:
                data = json.load(f)
                self.employees = []
                for item in data:
                    emp = Employee(
                        item["id"], item["name"], item["clock_in"], 
                        item["clock_out"], item["role"], item["salary"]
                    )
                    self.employees.append(emp)
        except Exception as e:
            print(f"Error reading data: {e}")
            self.employees = []

    def calculate_total_salaries(self):
        return sum(emp.salary for emp in self.employees)

    def get_employees(self):
        return self.employees