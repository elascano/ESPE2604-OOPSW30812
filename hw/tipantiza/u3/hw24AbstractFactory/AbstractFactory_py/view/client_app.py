import sys
import os

sys.path.insert(0, os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from model.gui_factory import GUIFactory
from controller.config_reader import ConfigReader

class ClientApp:
    
    @staticmethod
    def main():
        print("=== Abstract Factory Pattern Demo ===")
        print(f"Operating System: {ConfigReader.get_operating_system_name()}")
        print("----------------------------------------")
        
        a_factory = GUIFactory.get_factory()
        
        a_button = a_factory.create_button()
        a_button.caption = "play"
        a_button.paint()
        
        a_menu = a_factory.create_menu()
        a_menu.caption = "Main Menu"
        a_menu.paint()
        
        print("----------------------------------------")
        
        another_button = a_factory.create_button()
        another_button.caption = "stop"
        another_button.paint()
        
        another_menu = a_factory.create_menu()
        another_menu.caption = "Context Menu"
        another_menu.paint()

if __name__ == "__main__":
    ClientApp.main()