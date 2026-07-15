from model.Button import Button

class WinButton(Button):
    def paint(self):
        print(f"I am a WinButton: {self.caption}")