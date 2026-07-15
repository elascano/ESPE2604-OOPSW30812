from model.button import Button

class LinuxButton(Button):

    def paint(self):
        print("I am a LinuxButton:", self.caption)