class Keyboard:

    def __init__(self, id, name, price, key_count):
        self.id = id
        self.name = name
        self.price = float(price)
        self.key_count = int(key_count)

    def calculate_value(self):
        return self.price * self.key_count

    def __str__(self):
        return f"{self.id} - {self.name} - ${self.price} - {self.key_count} keys"