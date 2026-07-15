from model.menu import Menu

class WinMenu(Menu):
    def paint(self):
        return f"I'm a WinMenu: {self.caption}"