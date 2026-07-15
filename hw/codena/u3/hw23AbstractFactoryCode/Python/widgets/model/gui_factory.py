from abc import ABC, abstractmethod

from controller.config_reader import ConfigReader

class GUIFactory(ABC):

    @staticmethod
    def getFactory():

        from model.win_factory import WinFactory
        from model.linux_factory import LinuxFactory

        sys = ConfigReader.readFromConfigFile("OS_TYPE")

        if sys == 0:
            return WinFactory()
        else:
            return LinuxFactory()

    @abstractmethod
    def createButton(self):
        pass

    @abstractmethod
    def createMenu(self):
        pass