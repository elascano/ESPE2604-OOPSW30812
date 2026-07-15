from model.menu import Menu

class LinuxMenu(Menu):

    def paint(self):
        print("I am a LinuxMenu:", self.caption)