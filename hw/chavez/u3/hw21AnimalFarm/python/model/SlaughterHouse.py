class SlaughterHouse:

    def __init__(self, name):
        self.name = name

    def slaughter(self, animal):
        print(f"The {animal.__class__.__name__.lower()} has been sent to slaughter house {self.name}")