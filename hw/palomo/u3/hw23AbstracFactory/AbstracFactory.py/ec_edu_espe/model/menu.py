from abc import ABC, abstractmethod

class Menu(ABC):
    """AbstractProduct: representa un menu generico."""

    @abstractmethod
    def paint(self) -> None:
        ...