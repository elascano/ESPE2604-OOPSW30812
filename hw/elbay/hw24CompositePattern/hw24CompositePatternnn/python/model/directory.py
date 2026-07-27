from model.file_system_item import FileSystemItem


class Directory(FileSystemItem):
    def __init__(self, name):
        super().__init__()
        self.name = name
        self.contents = []

    def describe(self):
        super().describe()
        for item in self.contents:
            item.describe()

    def add(self, item):
        self.contents.append(item)
