from abc import ABC, abstractmethod

class Employee(ABC):

    def __init__(self, name: str) -> None:
        self.name = name

    @abstractmethod
    def get_role(self) -> str:
        """Specific role of the employee."""
        ...

    def state_name(self) -> None:

        print(f"{self.name} - {self.get_role()}")