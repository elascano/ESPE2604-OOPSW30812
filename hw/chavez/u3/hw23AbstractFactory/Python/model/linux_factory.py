from model.gui_factory import GUIFactory
from model.linux_button import LinuxButton
from model.linux_menu import LinuxMenu

class LinuxFactory(GUIFactory):

    def create_button(self):
        return LinuxButton()

    def create_menu(self):
        return LinuxMenu()