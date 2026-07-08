from .Door import Door

class EntranceDoor(Door):
    def open(self) -> None:
        print("Opening the entrance door from the outside")