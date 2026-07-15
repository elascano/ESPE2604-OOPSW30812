from abc import ABC, abstractmethod
from button import Button
from menu import Menu

class GUIFactory(ABC):
    @staticmethod
    def get_factory():
        sys = GUIFactory.read_from_config_file("OS_TYPE")
        if sys == 0:
            from win_factory import WinFactory
            return WinFactory()
        else:
            from linux_factory import LinuxFactory
            return LinuxFactory()

    @staticmethod
    def read_from_config_file(key):
        return 0

    @abstractmethod
    def create_button(self) -> Button:
        pass

    @abstractmethod
    def create_menu(self) -> Menu:
        pass