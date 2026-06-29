class Food:
    def __init__(self, name):
        self.name = name


class SlaughterHouse:
    def __init__(self):
        self.storage = []

    def receive(self, animal):
        self.storage.append(animal)


class Cut:
    def __init__(self, type_, yield_):
        self.type = type_
        self.yield_ = yield_