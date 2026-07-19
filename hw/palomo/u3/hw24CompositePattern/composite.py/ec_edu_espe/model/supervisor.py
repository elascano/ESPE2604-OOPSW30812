from typing import List

from ec_edu_espe.model.employee import Employee


class Supervisor(Employee):

    def __init__(self, name: str) -> None:
        super().__init__(name)
        self.subordinates: List[Employee] = []

    def get_role(self) -> str:
        return "Supervisor"

    def add_employee(self, employee: Employee) -> None:
        self.subordinates.append(employee)

    def remove_employee(self, employee: Employee) -> None:
        self.subordinates.remove(employee)

    def state_name(self) -> None:
        super().state_name()
        for employee in self.subordinates:
            employee.state_name()