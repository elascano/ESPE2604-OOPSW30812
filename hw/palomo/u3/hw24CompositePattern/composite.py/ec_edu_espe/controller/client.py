from ec_edu_espe.model.employee import Employee

class Client:

    def __init__(self, root: Employee) -> None:
        self._root = root

    def mostrar_organigrama(self) -> None:
        """Solicita el reporte completo de la organizacion desde la raiz."""
        self._root.state_name()