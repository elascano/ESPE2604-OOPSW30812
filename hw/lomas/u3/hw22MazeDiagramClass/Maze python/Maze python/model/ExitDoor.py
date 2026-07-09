from .Door import Door

class ExitDoor(Door):
    def open(self) -> None:
        print("Opening the EXIT door. Maze completed")