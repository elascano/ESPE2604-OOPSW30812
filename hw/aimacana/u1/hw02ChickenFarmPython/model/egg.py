class Egg:
    def __init__(self, id):
        self.id = id

    @property
    def get_id(self):
        return self.id

    @id.setter
    def set_id(self, id):
        self.id = id

    def __str__(self):
        return f"Egg(id={self.id})"
