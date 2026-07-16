from abc import ABC, abstractmethod
from controller.config_reader import ConfigReader

class GUIFactory(ABC):
    
    @staticmethod
    def get_factory():
        sys_type = ConfigReader.get_os_type()
        if sys_type == 0:
            from model.win_factory import WinFactory
            return WinFactory()
        elif sys_type == 2:
            from model.mac_factory import MacFactory
            return MacFactory()
        else:
            from model.linux_factory import LinuxFactory
            return LinuxFactory()
    
    @abstractmethod
    def create_button(self):
        pass
    
    @abstractmethod
    def create_menu(self):
        pass