from model.path import Path


class PathController:

    def __init__(self):
        self._path = Path()

    def create_path(self):
        self._path = Path()

    def add_room(self, room):
        self._path.add_room(room)

    def verify_unique_path(self):
        return True