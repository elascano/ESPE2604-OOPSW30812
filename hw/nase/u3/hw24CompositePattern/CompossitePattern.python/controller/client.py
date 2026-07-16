# Jennyfer Nase 

class Client:
    employee = None

    @classmethod
    def do_client_tasks(cls):
        if cls.employee is not None:
            cls.employee.state_name()
        else:
            print("No employee assigned to the client.")