from model.menu import Menu

class WinMenu(Menu):
    def paint(self):
        return "I'm a WinMenu: " + self.caption