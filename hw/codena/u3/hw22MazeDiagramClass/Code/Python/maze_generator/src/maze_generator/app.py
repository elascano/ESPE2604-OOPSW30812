from __future__ import annotations

import argparse

from .controller import MazeController, MazeGeneratorController, RandomGenerator
from .view import FrmMaze, FrmMazeGenerator, MazeViewType


def build_controller() -> MazeGeneratorController:
    generator = RandomGenerator()
    validator = MazeController()
    return MazeGeneratorController(generator, validator)


def run(rows: int, columns: int, view_type: MazeViewType) -> FrmMaze:
    controller = build_controller()
    form = FrmMazeGenerator(rows=rows, columns=columns, type_of_maze=view_type)
    return form.generate(controller)


def _parse_arguments() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="Generate and draw a random maze.")
    parser.add_argument("--rows", type=int, default=10, help="Number of rows.")
    parser.add_argument("--columns", type=int, default=10, help="Number of columns.")
    parser.add_argument(
        "--view",
        choices=[view.name.lower() for view in MazeViewType],
        default=MazeViewType.CONSOLE.name.lower(),
        help="How to draw the maze.",
    )
    return parser.parse_args()


def main() -> None:
    arguments = _parse_arguments()
    view_type = MazeViewType[arguments.view.upper()]
    run(arguments.rows, arguments.columns, view_type)


if __name__ == "__main__":
    main()
