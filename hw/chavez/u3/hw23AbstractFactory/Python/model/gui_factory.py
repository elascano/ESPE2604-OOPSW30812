from abc import ABC, abstractmethod
import platform

class GUIFactory(ABC):

    @staticmethod
    def get_factory():
        if platform.system() == "Windows":
            from model.win_factory import WinFactory
            return WinFactory()
        else:
            from model.linux_factory import LinuxFactory
            return LinuxFactory()

    @abstractmethod
    def create_button(self):
        pass

    @abstractmethod
    def create_menu(self):
        pass