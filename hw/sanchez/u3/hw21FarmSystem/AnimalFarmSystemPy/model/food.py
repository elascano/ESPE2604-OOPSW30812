class Food:
    def __init__(self, id, description):
        self._id = id
        self._description = description

    def get_id(self): return self._id
    def set_id(self, id): self._id = id
    def get_description(self): return self._description
    def set_description(self, description): self._description = description