from menu import Menu

class WinMenu(Menu):

    def paint(self):
        print(f"I'm a Windows Menu: {self.caption}")