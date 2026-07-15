class RoomController:

    def __init__(self, room):
        self._room = room

    def add_door(self, door):
        self._room.add_door(door)

    def add_wall(self, wall):
        self._room.add_wall(wall)

    def count_doors(self):
        return len(self._room.doors)

    def count_walls(self):
        return len(self._room.walls)

    def validate_room(self):
        return len(self._room.doors) > 0