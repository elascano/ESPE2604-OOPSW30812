class Product:

    def __init__(self, name, weight_pounds):
        self.name = name
        self.weight_pounds = weight_pounds

    def to_dict(self):
        return {
            "name": self.name,
            "weight_pounds": self.weight_pounds
        }