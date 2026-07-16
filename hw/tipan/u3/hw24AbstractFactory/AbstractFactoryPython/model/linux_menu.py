from model.menu import Menu

class LinuxMenu(Menu):
    def paint(self):
        return "I'm a LinuxMenu: " + self.caption