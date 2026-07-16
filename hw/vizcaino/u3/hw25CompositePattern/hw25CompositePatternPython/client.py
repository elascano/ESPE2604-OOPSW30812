class Client:
    employee = None

    @staticmethod
    def do_client_tasks():
        if Client.employee:
            Client.employee.state_name()