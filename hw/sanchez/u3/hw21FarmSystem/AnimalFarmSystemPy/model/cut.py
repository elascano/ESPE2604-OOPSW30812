class Cut:
    def __init__(self, id, description, procedure, weight):
        self._id = id
        self._description = description
        self._procedure = procedure
        self._weight = weight

    def get_id(self): return self._id
    def set_id(self, id): self._id = id
    def get_description(self): return self._description
    def set_description(self, description): self._description = description
    def get_procedure(self): return self._procedure
    def set_procedure(self, procedure): self._procedure = procedure
    def get_weight(self): return self._weight
    def set_weight(self, weight): self._weight = weight