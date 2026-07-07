class SlaughterHouse:
    def __init__(self, id, name, address, cellphone_number):
        self._id = id
        self._name = name
        self._address = address
        self._cellphone_number = cellphone_number

    def get_id(self): return self._id
    def set_id(self, id): self._id = id
    def get_name(self): return self._name
    def set_name(self, name): self._name = name
    def get_address(self): return self._address
    def set_address(self, address): self._address = address
    def get_cellphone_number(self): return self._cellphone_number
    def set_cellphone_number(self, cellphone_number): self._cellphone_number = cellphone_number