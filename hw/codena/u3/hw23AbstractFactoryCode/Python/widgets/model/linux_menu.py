from model.menu import Menu

class LinuxMenu(Menu):

    def paint(self):
        print(f"I'm a Linux Menu: {self.caption}")