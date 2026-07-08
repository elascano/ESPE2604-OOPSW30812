from renderer.maze_renderer import MazeRenderer


class MazePrinter(MazeRenderer):

    def render(self, maze):
        print("=== Maze Display ===")
        print(f"Width: {maze.get_width()}")
        print(f"Height: {maze.get_height()}")
        print()

        for y in range(maze.get_height()):
            for x in range(maze.get_width()):
                room = maze.get_room(x, y)

                if room is not None:
                    symbol = "."

                    if room.is_entrance():
                        symbol = "S"
                    elif room.is_exit():
                        symbol = "E"

                    print(symbol, end=" ")
                else:
                    print("#", end=" ")

            print()

        print(
            "\nSolution Path: "
            + (
                f"Valid: {maze.get_solution_path().is_valid_unique_path()}"
                if maze.get_solution_path() is not None
                else "No path"
            )
        )