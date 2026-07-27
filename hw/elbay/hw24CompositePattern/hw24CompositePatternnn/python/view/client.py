class Client:
    root_item = None

    @staticmethod
    def do_client_tasks():
        if Client.root_item is not None:
            Client.root_item.describe()
