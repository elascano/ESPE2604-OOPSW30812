from ec_edu_espe.controller.client import Client
from ec_edu_espe.model.clerk import Clerk
from ec_edu_espe.model.manager import Manager
from ec_edu_espe.model.president import President
from ec_edu_espe.model.supervisor import Supervisor
from ec_edu_espe.model.teller import Teller


def main() -> None:
    # Hojas
    clerk1 = Clerk("Ana")
    clerk2 = Clerk("Martha")
    teller1 = Teller("Rosa")

    # Compuestos
    supervisor = Supervisor("Josue")
    supervisor.add_employee(clerk1)
    supervisor.add_employee(clerk2)
    supervisor.add_employee(teller1)

    manager = Manager("Sofia")
    manager.add_employee(supervisor)

    president = President("Juan")
    president.add_employee(manager)

    client = Client(president)
    client.mostrar_organigrama()


if __name__ == "__main__":
    main()