from ec_edu_espe.model.menu import Menu

class LinuxMenu(Menu):
    """ConcreteProduct: menu con estilo Linux."""

    def paint(self) -> None:
        print("Renderizando un menu con estilo Linux.")