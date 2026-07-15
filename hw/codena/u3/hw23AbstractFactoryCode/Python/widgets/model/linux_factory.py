from model.gui_factory import GUIFactory
from model.linux_button import LinuxButton
from model.linux_menu import LinuxMenu


class LinuxFactory(GUIFactory):

    def createButton(self):
        return LinuxButton()

    def createMenu(self):
        return LinuxMenu()