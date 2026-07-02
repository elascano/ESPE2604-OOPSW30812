# Author: Didier Elbay
# Cut model - OOP Concepts Zoo Project


class Cut:
    def __init__(self, id_cut, description, procedure, weight):
        self.id = id_cut
        self.description = description
        self.procedure = procedure
        self.weight = weight

    def __str__(self):
        return f"Cut({self.description}, {self.weight} kg)"
