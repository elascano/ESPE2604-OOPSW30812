class User:
    def __init__(self, id, user_name, password):
        self.id = id
        self.user_name = user_name
        self.password = password

    def get_user_name(self):
        return self.user_name

    def get_password(self):
        return self.password