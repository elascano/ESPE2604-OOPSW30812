from ec_edu_espe.model.menu import Menu


class WinMenu(Menu):
    """ConcreteProduct: menu con estilo Windows."""

    def paint(self) -> None:
        print("Renderizando un menu con estilo Windows.")