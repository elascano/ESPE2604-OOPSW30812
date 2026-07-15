from model.button import Button

class WinButton(Button):

    def paint(self):
        print("I am a WinButton:", self.caption)