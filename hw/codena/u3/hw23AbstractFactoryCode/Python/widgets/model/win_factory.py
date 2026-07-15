from model.gui_factory import GUIFactory
from model.win_button import WinButton
from model.win_menu import WinMenu


class WinFactory(GUIFactory):

    def createButton(self):
        return WinButton()

    def createMenu(self):
        return WinMenu()