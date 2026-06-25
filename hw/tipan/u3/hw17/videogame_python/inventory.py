class Inventory:

    def __init__(self):
        self.items = []

    def add_item(self, item):
        self.items.append(item)

    def show(self):
        print("Inventory:")
        for i in self.items:
            print("-", i)