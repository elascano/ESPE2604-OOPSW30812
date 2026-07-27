from model.gui_factory import GUIFactory

#@author Christopher Lomas,<CodeBros,@ESPE>


class WidgetController:
    def generate_widgets(self):
        factory = GUIFactory.get_factory()
        
        button = factory.create_button()
        button.caption = "Play"
        
        menu = factory.create_menu()
        menu.caption = "File"
        
        return f"{button.paint()}\n{menu.paint()}"