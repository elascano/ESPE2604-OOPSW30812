class Employee:

    def __init__(self, name, title):
        self.name = name
        self.title = title

    def state_name(self):
        print(f"{self.title} {self.name}")