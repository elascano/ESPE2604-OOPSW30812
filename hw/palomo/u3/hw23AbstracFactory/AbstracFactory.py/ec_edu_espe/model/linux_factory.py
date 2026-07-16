from ec_edu_espe.model.gui_factory import GUIFactory
from ec_edu_espe.model.linux_button import LinuxButton
from ec_edu_espe.model.linux_menu import LinuxMenu


class LinuxFactory(GUIFactory):
    """ConcreteFactory: crea la familia de productos con estilo Linux."""

    def create_button(self) -> LinuxButton:
        return LinuxButton()

    def create_menu(self) -> LinuxMenu:
        return LinuxMenu()