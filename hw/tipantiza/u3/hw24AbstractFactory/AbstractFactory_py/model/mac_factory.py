from model.gui_factory import GUIFactory
from model.mac_button import MacButton
from model.mac_menu import MacMenu

class MacFactory(GUIFactory):
    def create_button(self):
        return MacButton()
    
    def create_menu(self):
        return MacMenu()