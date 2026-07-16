from model.button import Button

class WinButton(Button):
    def paint(self):
        print(f"I'm a WnButton: {self.caption}")