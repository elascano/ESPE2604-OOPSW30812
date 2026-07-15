from gui_factory import GUIFactory
from mac_button import MacButton
from mac_menu import MacMenu

class MacFactory(GUIFactory):

    def create_button(self):
        return MacButton()

    def create_menu(self):
        return MacMenu()