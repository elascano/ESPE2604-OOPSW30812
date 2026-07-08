import random

from maze_generator.controller import (
    MazeController,
    MazeGeneratorController,
    RandomGenerator,
)
from maze_generator.model import Coordinate, Maze
from maze_generator.view import ConsoleMaze, FrmMazeGenerator, MazeViewType


def _generated_maze(rows: int = 6, columns: int = 6) -> Maze:
    maze = Maze(rows, columns)
    RandomGenerator(random.Random(42)).generate_maze(maze)
    return maze


def test_generated_maze_defines_entrance_and_exit():
    maze = _generated_maze()
    assert maze.entrance == Coordinate(0, 0)
    assert maze.exit == Coordinate(maze.columns - 1, maze.rows - 1)


def test_validate_path_finds_a_solution():
    maze = _generated_maze()
    controller = MazeController()

    assert controller.validate_path(maze) is True
    assert not maze.path.is_empty
    assert maze.path.steps[0] == maze.entrance
    assert maze.path.steps[-1] == maze.exit


def test_path_steps_are_connected_by_doors():
    maze = _generated_maze()
    MazeController().validate_path(maze)

    steps = maze.path.steps
    for current, following in zip(steps, steps[1:]):
        room = maze.get_room(current)
        directions = [door.cardinal_direction for door in room.doors]
        neighbours = [current.translated(direction) for direction in directions]
        assert following in neighbours


def test_controller_generates_and_draws_console_view():
    generator = RandomGenerator(random.Random(7))
    controller = MazeGeneratorController(generator, MazeController())
    form = FrmMazeGenerator(rows=5, columns=5, type_of_maze=MazeViewType.CONSOLE)

    view = form.generate(controller)

    assert isinstance(view, ConsoleMaze)
