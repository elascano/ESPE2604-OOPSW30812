from gui_factory import GUIFactory
from win_button import WinButton
from win_menu import WinMenu

class WinFactory(GUIFactory):
    def create_button(self):
        return WinButton()

    def create_menu(self):
        return WinMenu()