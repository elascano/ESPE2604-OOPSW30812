from model.menu import Menu

class LinuxMenu(Menu):
    def paint(self):
        return f"I'm a LinuxMenu: {self.caption}"