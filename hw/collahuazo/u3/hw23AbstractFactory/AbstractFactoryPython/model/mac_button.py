from model.button import Button


class MacButton(Button):
    def paint(self):
        print(f"I'm a MacButton: {self.caption}")
