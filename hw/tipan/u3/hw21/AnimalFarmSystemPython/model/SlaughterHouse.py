class SlaughterHouse:
    def __init__(self, id, name, address, cellphone_number):
        self.id = id
        self.name = name
        self.address = address
        self.cellphone_number = cellphone_number

    def __str__(self):
        return (f"SlaughterHouse{{id={self.id}, "
                f"name={self.name}, "
                f"address={self.address}}}")