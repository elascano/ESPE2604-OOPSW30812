from ec_edu_espe.controller.client_app import ClientApp
from ec_edu_espe.model.gui_factory import GUIFactory

def main() -> None:
    print("=== Abstract Factory - GUI Multiplataforma ===")
    os_name = input("Ingrese el sistema operativo (windows/linux): ")

    try:
        factory = GUIFactory.get_factory(os_name)

        app = ClientApp(factory)
        app.crear_interfaz()
        app.renderizar_interfaz()

    except ValueError as error:
        print(f"Error: {error}")


if __name__ == "__main__":
    main()