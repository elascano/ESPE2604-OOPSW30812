class Poop:
    def __init__(self, size, color):
        self.size = size
        self.color = color

    def __str__(self):
        return f"Poop{{size={self.size}, color={self.color}}}"