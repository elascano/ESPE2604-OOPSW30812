from character import Character

class Mage(Character):

    def __init__(self, id, name, level, health):
        super().__init__(id, name, level, health)

    def attack(self):
        print(f"{self.name} casts a fire spell")