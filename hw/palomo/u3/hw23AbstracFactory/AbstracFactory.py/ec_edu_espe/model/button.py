from abc import ABC, abstractmethod

class Button(ABC):
    """AbstractProduct: representa un boton generico."""

    @abstractmethod
    def paint(self) -> None:
        ...