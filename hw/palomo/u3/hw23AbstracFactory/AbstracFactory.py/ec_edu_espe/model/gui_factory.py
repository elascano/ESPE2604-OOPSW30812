from abc import ABC, abstractmethod

from ec_edu_espe.model.button import Button
from ec_edu_espe.model.menu import Menu


class GUIFactory(ABC):
    """AbstractFactory: declara los metodos de creacion de cada producto."""

    @abstractmethod
    def create_button(self) -> Button:
        ...

    @abstractmethod
    def create_menu(self) -> Menu:
        ...

    @staticmethod
    def get_factory(os: str) -> "GUIFactory":
        """
        Punto unico de creacion: decide que ConcreteFactory instanciar
        segun el sistema operativo indicado (equivalente al +getFactory()
        del diagrama).
        """
        # import local para evitar dependencia circular con las fabricas concretas
        from ec_edu_espe.model.win_factory import WinFactory
        from ec_edu_espe.model.linux_factory import LinuxFactory

        if os is None:
            raise ValueError("El sistema operativo no puede ser None.")

        normalized = os.strip().lower()
        if normalized == "windows":
            return WinFactory()
        if normalized == "linux":
            return LinuxFactory()
        raise ValueError(f"Sistema operativo no soportado: {os}")