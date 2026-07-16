from typing import Optional

from ec_edu_espe.model.button import Button
from ec_edu_espe.model.gui_factory import GUIFactory
from ec_edu_espe.model.menu import Menu

class ClientApp:
   
    def __init__(self, factory: GUIFactory) -> None:
        self._factory = factory
        self._button: Optional[Button] = None
        self._menu: Optional[Menu] = None

    def crear_interfaz(self) -> None:
        """Crea la familia de componentes correspondiente a la fabrica inyectada."""
        self._button = self._factory.create_button()
        self._menu = self._factory.create_menu()

    def renderizar_interfaz(self) -> None:
        """Dibuja los componentes previamente creados."""
        if self._button is None or self._menu is None:
            raise RuntimeError("Debe llamar a crear_interfaz() antes de renderizar.")
        self._button.paint()
        self._menu.paint()

    @property
    def button(self) -> Optional[Button]:
        return self._button

    @property
    def menu(self) -> Optional[Menu]:
        return self._menu
