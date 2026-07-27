from model.file_system_item import FileSystemItem


class ImageFile(FileSystemItem):
    def __init__(self, name, size):
        super().__init__()
        self.name = name
        self.size = size

    def describe(self):
        super().describe()
