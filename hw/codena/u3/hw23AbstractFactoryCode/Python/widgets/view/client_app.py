from model.gui_factory import GUIFactory


def main():

    factory = GUIFactory.getFactory()

    button = factory.createButton()
    menu = factory.createMenu()

    button.caption = "Play"
    menu.caption = "Configuration"

    button.paint()
    menu.paint()


if __name__ == "__main__":
    main()