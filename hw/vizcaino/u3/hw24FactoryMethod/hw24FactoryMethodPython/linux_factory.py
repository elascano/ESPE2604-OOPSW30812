from gui_factory import GUIFactory
from linux_button import LinuxButton
from linux_menu import LinuxMenu

class LinuxFactory(GUIFactory):
    def create_button(self):
        return LinuxButton()

    def create_menu(self):
        return LinuxMenu()