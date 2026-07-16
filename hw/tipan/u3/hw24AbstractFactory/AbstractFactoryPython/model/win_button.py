from model.button import Button

class WinButton(Button):
    def paint(self):
        return "I'm a WinButton: " + self.caption