class Room:

    def __init__(self, x, y):
        self.x = x
        self.y = y
        self._is_entrance = False
        self._is_exit = False
        self.connecting_doors = []

    def get_connecting_doors(self):
        return self.connecting_doors

    def add_door(self, door):
        self.connecting_doors.append(door)

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y

    def is_entrance(self):
        return self._is_entrance

    def set_entrance(self, entrance):
        self._is_entrance = entrance

    def is_exit(self):
        return self._is_exit

    def set_exit(self, exit_room):
        self._is_exit = exit_room

    def __str__(self):
        return (
            f"Room({self.x}, {self.y}) "
            f"[Entrance: {self._is_entrance}, Exit: {self._is_exit}]"
        )