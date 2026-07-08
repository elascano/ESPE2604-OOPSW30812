import random

from generator.maze_generator_algorithm import MazeGeneratorAlgorithm
from model.door import Door
from model.path import Path
from model.room import Room


class MazeGenerator(MazeGeneratorAlgorithm):

    def __init__(self):
        self.random = random.Random()

    def generate_maze(self, maze):

        for y in range(maze.get_height()):
            for x in range(maze.get_width()):

                room = Room(x, y)

                if self.random.choice([True, False]):
                    room.add_door(Door())

                if self.random.choice([True, False]):
                    room.add_door(Door(True))

                maze.add_room(x, y, room)

        entrance = maze.get_room(0, 0)

        if entrance is not None:
            entrance.set_entrance(True)

        exit_room = maze.get_room(
            maze.get_width() - 1,
            maze.get_height() - 1
        )

        if exit_room is not None:
            exit_room.set_exit(True)

        path = Path()

        for y in range(maze.get_height()):
            for x in range(maze.get_width()):

                room = maze.get_room(x, y)

                if room is not None:
                    path.add_room(room)

        maze.set_solution_path(path)