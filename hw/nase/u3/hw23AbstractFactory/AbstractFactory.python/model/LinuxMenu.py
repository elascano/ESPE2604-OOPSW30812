from model.Menu import Menu

class LinuxMenu(Menu):
    def paint(self):
        print(f"I am a LinuxMenu: {self.caption}")