from model.button import Button

class LinuxButton(Button):
    def paint(self):
        return "I'm a LinuxButton: " + self.caption