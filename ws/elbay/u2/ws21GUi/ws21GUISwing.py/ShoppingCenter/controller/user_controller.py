from model.user import User

class UserController:
    def __init__(self):
        self.user = None

    def login(self, user_name, password):
        self.user = User(1, "Christopher", "Christopher")
        return self.user.get_user_name() == user_name and self.user.get_password() == password