from model.menu import Menu


class MacMenu(Menu):
    def paint(self):
        print(f"I'm a MacMenu: {self.caption}")
