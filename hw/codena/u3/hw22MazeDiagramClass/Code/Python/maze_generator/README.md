# Maze Generator

A small command-line maze generator written in Python. The project is a Python
translation of the provided UML class diagram and is organised following clean
code guidelines and the SOLID principles.

## Features

- Generates a random, always-solvable maze using the randomized depth-first
  search algorithm (recursive backtracker).
- Validates that the entrance and the exit are connected and stores the
  solution path.
- Draws the maze either in the console (ASCII) or in a Tkinter window.

## Project structure

```
src/maze_generator/
├── model/         # Domain entities
│   ├── cardinal_direction.py   # CardinalDirection
│   ├── coordinate.py           # Coordinate
│   ├── wall.py                 # Wall
│   ├── door.py                 # Door (abstract)
│   ├── entrance_door.py        # EntranceDoor
│   ├── exit_door.py            # ExitDoor
│   ├── adjacent_door.py        # AdjacentDoor
│   ├── room.py                 # Room
│   ├── path.py                 # Path
│   └── maze.py                 # Maze
├── controller/    # Use cases and abstractions
│   ├── i_maze_generator.py         # IMazeGenerator (interface)
│   ├── i_draw.py                   # IDraw (interface)
│   ├── random_generator.py         # RandomGenerator
│   ├── maze_controller.py          # MazeController
│   └── maze_generator_controller.py# MazeGeneratorController
├── view/          # Presentation
│   ├── frm_maze.py             # FrmMaze (abstract)
│   ├── console_maze.py         # ConsoleMaze
│   ├── frm_gui_maze.py         # FrmGUIMaze
│   ├── maze_view_type.py       # MazeViewType
│   └── frm_maze_generator.py   # FrmMazeGenerator
└── app.py         # Composition root
```

## How the SOLID principles are applied

- **Single Responsibility** — `MazeController` only validates the path.
- **Open/Closed** — new views subclass `FrmMaze` without touching existing code.
- **Liskov Substitution** — `EntranceDoor`, `ExitDoor` and `AdjacentDoor` can
  replace `Door` anywhere.
- **Interface Segregation** — `IDraw` exposes only the drawing operation.
- **Dependency Inversion** — `MazeGeneratorController` depends on the
  `IMazeGenerator` abstraction, not on a concrete algorithm.

## Requirements

- Python 3.10 or newer.
- Tkinter is only needed for the graphical view (it ships with most Python
  installations). The console view has no external dependencies.

## Usage

Run the generator with the console view:

```bash
python main.py --rows 12 --columns 12 --view console
```

Run it with the graphical view (requires a display and Tkinter):

```bash
python main.py --rows 12 --columns 12 --view gui
```

You can also install the package and use the console script:

```bash
pip install -e .
maze-generator --rows 10 --columns 10
```

Legend of the console view: `S` = start, `E` = end, `.` = solution path.

## Running the tests

```bash
pip install -e ".[dev]"
pytest
```
