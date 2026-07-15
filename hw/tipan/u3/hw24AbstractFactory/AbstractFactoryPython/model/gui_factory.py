from abc import ABC, abstractmethod

class GUIFactory(ABC):
    @staticmethod
    def get_factory():
        sys = 0  # 0 para Windows, 1 para Linux
        
        if sys == 0:
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