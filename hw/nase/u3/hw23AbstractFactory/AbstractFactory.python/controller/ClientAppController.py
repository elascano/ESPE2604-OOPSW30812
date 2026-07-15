from model.GUIFactory import GUIFactory
from view.Console import Console

class ClientAppController:
    @staticmethod
    def run():
        view = Console()
        
        a_factory = GUIFactory.get_factory()
        
        a_button = a_factory.create_button()
        a_button.caption = "Play"
        view.render_button(a_button)
        
        a_menu = a_factory.create_menu()
        a_menu.caption = "File"
        view.render_menu(a_menu)