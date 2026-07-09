class DoorController:

    def __init__(self, door):
        self._door = door

    def open_door(self):
        self._door.open_door()

    def close_door(self):
        self._door.close_door()

    def connect_rooms(self):
        print("Rooms connected.")