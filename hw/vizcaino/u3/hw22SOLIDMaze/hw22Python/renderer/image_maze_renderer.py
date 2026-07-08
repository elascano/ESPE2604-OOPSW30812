from PIL import Image
from PIL import ImageDraw

from renderer.maze_renderer import MazeRenderer


class ImageMazeRenderer(MazeRenderer):

    def __init__(self, file_format):
        self.file_format = file_format

    def render(self, maze):
        cell_size = 30

        width = maze.get_width() * cell_size
        height = maze.get_height() * cell_size

        image = Image.new(
            "RGB",
            (width, height),
            "white"
        )

        draw = ImageDraw.Draw(image)

        for y in range(maze.get_height()):
            for x in range(maze.get_width()):

                room = maze.get_room(x, y)

                x_pos = x * cell_size
                y_pos = y * cell_size

                if room is not None:

                    if room.is_entrance():
                        color = "green"
                    elif room.is_exit():
                        color = "red"
                    else:
                        color = "lightgray"

                    draw.rectangle(
                        (
                            x_pos,
                            y_pos,
                            x_pos + cell_size,
                            y_pos + cell_size
                        ),
                        fill=color,
                        outline="black"
                    )

        output_file = f"maze.{self.file_format}"

        image.save(output_file)

        print(
            f"Maze image saved as: {output_file}"
        )