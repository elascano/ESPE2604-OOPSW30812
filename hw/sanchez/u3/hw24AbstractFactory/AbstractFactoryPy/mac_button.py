from button import Button

class MacButton(Button):

    def paint(self):
        print(f"I'm a MacOS Button: {self.caption}")