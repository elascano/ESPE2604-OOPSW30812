from ec_edu_espe.model.button import Button

class LinuxButton(Button):
    """ConcreteProduct: boton con estilo Linux."""

    def paint(self) -> None:
        print("Renderizando un boton con estilo Linux.")