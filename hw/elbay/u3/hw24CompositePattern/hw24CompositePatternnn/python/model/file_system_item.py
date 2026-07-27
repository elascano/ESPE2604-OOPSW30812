class FileSystemItem:
    def __init__(self):
        self.name = "unnamed"
        self.size = 0

    def describe(self):
        print(f"{self.name} - {self.size}KB")
