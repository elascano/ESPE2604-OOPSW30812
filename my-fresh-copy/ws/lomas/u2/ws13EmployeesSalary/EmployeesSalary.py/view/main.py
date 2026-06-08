import sys
import os


sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), "..")))

from model.EmployeeModel import EmployeeModel

def run_application():
    model = EmployeeModel()
    
    print("=== EMPLOYEE MANAGEMENT SYSTEM (PYTHON) ===")
    try:
        num_employees = int(input("How many employees do you want to register? "))
    except ValueError:
        print("Invalid number. Exiting program.")
        return

   
    for i in range(num_employees):
        print(f"\n--- Registering Employee #{i + 1} ---")
        employee_id = input("Enter Employee ID: ")
        name = input("Enter Employee Name: ")
        try:
            salary = float(input("Enter Employee Salary: "))
        except ValueError:
            print("[ERROR]: Invalid salary. Please restart the registration for this employee.")
            return
            
        model.add_employee(employee_id, name, salary)

    
    print("\n[INFO]: Saving employee data to JSON file...")
    if model.save_to_file():
        print("[INFO]: Data saved successfully.")

    
    total_needed = model.calculate_total_salaries()
    employee_list = model.get_employees()

    print("\n=================================")
    print("        EMPLOYEE PAYROLL         ")
    print("=================================")
    for emp in employee_list:
        print(f"ID: {emp.id} | Name: {emp.name} | Salary: ${emp.salary:.2f}")
    print("---------------------------------")
    print(f"TOTAL BUDGET REQUIRED: ${total_needed:.2f}")
    print("=================================\n")

if __name__ == "__main__":
    run_application()