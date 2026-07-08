import pytest

from maze_generator.model import (
    AdjacentDoor,
    CardinalDirection,
    Coordinate,
    EntranceDoor,
    ExitDoor,
    Maze,
    Room,
    Wall,
)


def test_coordinate_translation_moves_towards_direction():
    origin = Coordinate(1, 1)
    assert origin.translated(CardinalDirection.NORTH) == Coordinate(1, 0)
    assert origin.translated(CardinalDirection.EAST) == Coordinate(2, 1)


def test_adding_a_door_removes_the_wall_on_the_same_side():
    room = Room(Coordinate(0, 0))
    room.add_wall(Wall(CardinalDirection.NORTH))
    room.add_door(AdjacentDoor(CardinalDirection.NORTH))

    assert room.has_door_towards(CardinalDirection.NORTH)
    assert room.walls == []


def test_adding_a_wall_is_ignored_when_a_door_already_exists():
    room = Room(Coordinate(0, 0))
    room.add_door(AdjacentDoor(CardinalDirection.EAST))
    room.add_wall(Wall(CardinalDirection.EAST))

    assert room.has_door_towards(CardinalDirection.EAST)
    assert room.walls == []


def test_maze_rejects_non_positive_sizes():
    with pytest.raises(ValueError):
        Maze(0, 5)


def test_maze_out_of_bounds_access_raises():
    maze = Maze(2, 2)
    with pytest.raises(ValueError):
        maze.get_room(Coordinate(5, 5))


def test_special_doors_expose_distinct_symbols():
    assert EntranceDoor(CardinalDirection.WEST).symbol == "S"
    assert ExitDoor(CardinalDirection.EAST).symbol == "E"
