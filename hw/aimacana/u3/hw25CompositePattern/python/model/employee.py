class Employee:
    def __init__(self):
        self.name = "not assigned yet"
        self.title = "not assigned yet"
        
    def state_name(self):
        return f"{self.title} {self.name}\n"
