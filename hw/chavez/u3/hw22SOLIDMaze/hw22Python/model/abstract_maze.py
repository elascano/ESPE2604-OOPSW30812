from abc import ABC, abstractmethod

from model.path import Path


class AbstractMaze(ABC):

    def __init__(self, width=5, height=5):
        self.width = width
        self.height = height
        self.rooms = []
        self.solution_path = Path()

        self._initialize_rooms()

    def _initialize_rooms(self):
        for _ in range(self.height):
            row = []

            for _ in range(self.width):
                room_list = []
                row.append(room_list)

            self.rooms.append(row)

    @abstractmethod
    def generate(self):
        pass

    def get_room(self, x, y):
        if 0 <= x < self.width and 0 <= y < self.height:
            room_list = self.rooms[y][x]

            if len(room_list) == 0:
                return None

            return room_list[0]

        return None

    def add_room(self, x, y, room):
        if 0 <= x < self.width and 0 <= y < self.height:
            self.rooms[y][x].append(room)

    def get_solution_path(self):
        return self.solution_path

    def set_solution_path(self, solution_path):
        self.solution_path = solution_path

    def get_width(self):
        return self.width

    def get_height(self):
        return self.height