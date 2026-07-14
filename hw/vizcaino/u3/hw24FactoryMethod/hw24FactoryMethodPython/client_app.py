from gui_factory import GUIFactory

class ClientApp:
    @staticmethod
    def main():
        a_factory = GUIFactory.get_factory()
        a_button = a_factory.create_button()
        a_button.caption = "Play"
        a_button.paint()

if __name__ == "__main__":
    ClientApp.main()