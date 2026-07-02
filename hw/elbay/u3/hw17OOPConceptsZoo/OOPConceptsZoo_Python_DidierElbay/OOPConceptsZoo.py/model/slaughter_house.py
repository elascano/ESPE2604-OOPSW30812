# Author: Didier Elbay
# SlaughterHouse model - OOP Concepts Zoo Project


class SlaughterHouse:
    def __init__(self, description):
        self.description = description

    def __str__(self):
        return f"SlaughterHouse({self.description})"
