from model.Menu import Menu

class WinMenu(Menu):
    def paint(self):
        print(f"I am a WinMenu: {self.caption}")