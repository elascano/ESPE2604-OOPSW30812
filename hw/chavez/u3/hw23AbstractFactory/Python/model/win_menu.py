from model.menu import Menu

class WinMenu(Menu):

    def paint(self):
        print("I am a WinMenu:", self.caption)