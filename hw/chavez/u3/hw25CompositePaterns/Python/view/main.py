from controller.employeeController import EmployeeController
from view.client import Client
def main():

    controller = EmployeeController()

    organization = controller.create_organization()

    client = Client(organization)

    client.show_organization()


if __name__ == "__main__":
    main()