from controller.employee_controller import EmployeeController
from model.supervisor import Supervisor


def print_organization(employee, level=0):
    print("   " * level + employee.state_name())

    if isinstance(employee, Supervisor):
        for e in employee.get_direct_reports():
            print_organization(e, level + 1)


def main():

    controller = EmployeeController()

    president = controller.build_organization()

    print("\n===== Composite Pattern =====\n")

    print_organization(president)


if __name__ == "__main__":
    main()