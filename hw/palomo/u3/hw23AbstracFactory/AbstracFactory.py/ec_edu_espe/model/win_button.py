from ec_edu_espe.model.button import Button

class WinButton(Button):
    """ConcreteProduct: boton con estilo Windows."""

    def paint(self) -> None:
        print("Renderizando un boton con estilo Windows.")