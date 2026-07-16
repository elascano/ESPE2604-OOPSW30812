from model.gui_factory import GUIFactory

class WidgetController:
    def generate_widgets(self):
        factory = GUIFactory.get_factory()
        
        button = factory.create_button()
        button.set_caption("Play")
        
        menu = factory.create_menu()
        menu.set_caption("File")
        
        result = ""
        result += button.paint()
        result += "\n"
        result += menu.paint()
        
        return result