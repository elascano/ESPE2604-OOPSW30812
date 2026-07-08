class Path:

    def __init__(self):
        self.steps = []

    def add_room(self, room):
        self.steps.append(room)

    def is_valid_unique_path(self):
        unique_rooms = set(id(room) for room in self.steps)
        return len(unique_rooms) == len(self.steps)

    def get_steps(self):
        return self.steps

    def clear(self):
        self.steps.clear()