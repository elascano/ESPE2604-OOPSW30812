from model.Button import Button

class LinuxButton(Button):
    def paint(self):
        print(f"I am a LinuxButton: {self.caption}")