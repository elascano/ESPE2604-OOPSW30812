from .Door import Door

class StandardDoor(Door):
    def open(self) -> None:
        print(f"Opening STANDARD door between({self.room1.x},{self.room1.y}) y ({self.room2.x},{self.room2.y}).")