import platform
from abc import ABC, abstractmethod

class GUIFactory(ABC):
    @staticmethod
    def get_factory():
        sys_type = GUIFactory.read_from_config_file("OS_TYPE")
        if sys_type == 0:
            from model.win_factory import WinFactory
            return WinFactory()
        else:
            from model.linux_factory import LinuxFactory
            return LinuxFactory()

    @staticmethod
    def read_from_config_file(key):
        os_name = platform.system().lower()
        if "win" in os_name:
            return 0
        else:
            return 1

    @abstractmethod
    def create_button(self):
        pass

    @abstractmethod
    def create_menu(self):
        pass