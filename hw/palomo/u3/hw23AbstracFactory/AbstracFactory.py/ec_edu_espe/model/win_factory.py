from ec_edu_espe.model.gui_factory import GUIFactory
from ec_edu_espe.model.win_button import WinButton
from ec_edu_espe.model.win_menu import WinMenu


class WinFactory(GUIFactory):
    """ConcreteFactory: crea la familia de productos con estilo Windows."""

    def create_button(self) -> WinButton:
        return WinButton()

    def create_menu(self) -> WinMenu:
        return WinMenu()