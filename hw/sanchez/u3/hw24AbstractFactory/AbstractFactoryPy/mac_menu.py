from menu import Menu

class MacMenu(Menu):

    def paint(self):
        print(f"I'm a MacOS Menu: {self.caption}")