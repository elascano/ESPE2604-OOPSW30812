class Client:
    employee = None

    @classmethod
    def do_client_tasks(cls):
        if cls.employee:
            cls.employee.state_name()