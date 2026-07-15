from model.gui_factory import GUIFactory

class GUIController:

    def start(self):

        factory = GUIFactory.get_factory()

        button = factory.create_button()
        button.caption = "Play"
        button.paint()

        menu = factory.create_menu()
        menu.caption = "File"
        menu.paint()