import tkinter as tk
from tkinter import messagebox
from tkinter import simpledialog

from controller.maze_controller import MazeController
from renderer.maze_printer import MazePrinter
from renderer.image_maze_renderer import ImageMazeRenderer


class MazeView(tk.Tk):

    def __init__(self):
        super().__init__()

        self.controller = None

        self.width_field = None
        self.height_field = None

        self.generate_button = None
        self.print_button = None
        self.image_button = None

        self.output_area = None
        self.maze_panel = None

        self.init_ui()
        self.init_controller()

    def init_ui(self):
        self.title("Maze Generator")
        self.geometry("800x600")

        control_panel = tk.Frame(self)
        control_panel.pack(fill=tk.X, padx=10, pady=10)

        tk.Label(
            control_panel,
            text="Width:"
        ).pack(side=tk.LEFT)

        self.width_field = tk.Entry(
            control_panel,
            width=5
        )
        self.width_field.insert(0, "5")
        self.width_field.pack(side=tk.LEFT)

        tk.Label(
            control_panel,
            text="Height:"
        ).pack(side=tk.LEFT)

        self.height_field = tk.Entry(
            control_panel,
            width=5
        )
        self.height_field.insert(0, "5")
        self.height_field.pack(side=tk.LEFT)

        self.generate_button = tk.Button(
            control_panel,
            text="Generate Maze",
            command=self.handle_generate_maze
        )
        self.generate_button.pack(
            side=tk.LEFT,
            padx=5
        )

        self.print_button = tk.Button(
            control_panel,
            text="Print to Console",
            command=self.handle_print_maze,
            state=tk.DISABLED
        )
        self.print_button.pack(
            side=tk.LEFT,
            padx=5
        )

        self.image_button = tk.Button(
            control_panel,
            text="Save as Image",
            command=self.handle_save_image,
            state=tk.DISABLED
        )
        self.image_button.pack(
            side=tk.LEFT,
            padx=5
        )

        self.maze_panel = tk.Canvas(
            self,
            bg="white"
        )

        self.maze_panel.pack(
            fill=tk.BOTH,
            expand=True,
            padx=10,
            pady=10
        )

        self.output_area = tk.Text(
            self,
            height=8,
            bg="black",
            fg="green"
        )

        self.output_area.pack(
            fill=tk.X,
            padx=10,
            pady=10
        )

    def init_controller(self):
        printer = MazePrinter()
        self.controller = MazeController(printer)

    def handle_generate_maze(self):

        try:
            width = int(
                self.width_field.get().strip()
            )

            height = int(
                self.height_field.get().strip()
            )

            if width < 2 or height < 2:
                messagebox.showerror(
                    "Invalid Input",
                    "Width and height must be at least 2!"
                )
                return

            self.controller.init_maze_generation(
                width,
                height
            )

            self.draw_maze()

            self.print_button.config(
                state=tk.NORMAL
            )

            self.image_button.config(
                state=tk.NORMAL
            )

            self.output_area.insert(
                tk.END,
                f"\n✓ Maze generated: {width}x{height}\n"
            )

            self.output_area.insert(
                tk.END,
                f"  Entrance at (0,0), Exit at ({width - 1},{height - 1})\n"
            )

        except ValueError:
            messagebox.showerror(
                "Invalid Input",
                "Please enter valid integer values!"
            )

    def handle_print_maze(self):

        printer = MazePrinter()

        self.controller.set_renderer(
            printer
        )

        self.output_area.insert(
            tk.END,
            "\n=== Console Maze Output ===\n"
        )

        self.controller.render_maze()

        self.output_area.insert(
            tk.END,
            "Done!\n"
        )

    def handle_save_image(self):

        image_format = simpledialog.askstring(
            "Image Format",
            "Enter image format (png/jpg):"
        )

        if image_format is None:
            return

        image_format = image_format.strip().lower()

        if image_format == "":
            return

        if image_format not in [
            "png",
            "jpg"
        ]:
            image_format = "png"

        image_renderer = ImageMazeRenderer(
            image_format
        )

        self.controller.set_renderer(
            image_renderer
        )

        self.controller.render_maze()

        self.output_area.insert(
            tk.END,
            f"\n✓ Image saved as maze.{image_format}\n"
        )

        self.output_area.insert(
            tk.END,
            f"  Format: {image_format.upper()}\n"
        )

    def draw_maze(self):

        self.maze_panel.delete("all")

        if self.controller is None:
            return

        if self.controller.get_model() is None:
            return

        maze = self.controller.get_model()

        width = maze.get_width()
        height = maze.get_height()

        if width == 0 or height == 0:
            return

        panel_width = self.maze_panel.winfo_width()
        panel_height = self.maze_panel.winfo_height()

        cell_size = min(
            panel_width // width,
            panel_height // height
        )

        cell_size = min(
            cell_size,
            60
        )

        offset_x = (
            panel_width - (cell_size * width)
        ) // 2

        offset_y = (
            panel_height - (cell_size * height)
        ) // 2

        for y in range(height):

            for x in range(width):

                room = maze.get_room(
                    x,
                    y
                )

                x_pos = (
                    offset_x +
                    x * cell_size
                )

                y_pos = (
                    offset_y +
                    y * cell_size
                )

                if room is not None:

                    if room.is_entrance():
                        color = "green"

                    elif room.is_exit():
                        color = "red"

                    else:
                        color = "lightgray"

                    self.maze_panel.create_rectangle(
                        x_pos,
                        y_pos,
                        x_pos + cell_size,
                        y_pos + cell_size,
                        fill=color,
                        outline="black"
                    )

                    if room.is_entrance():

                        self.maze_panel.create_text(
                            x_pos + cell_size / 2,
                            y_pos + cell_size / 2,
                            text="S"
                        )

                    elif room.is_exit():

                        self.maze_panel.create_text(
                            x_pos + cell_size / 2,
                            y_pos + cell_size / 2,
                            text="E"
                        )

                else:

                    self.maze_panel.create_rectangle(
                        x_pos,
                        y_pos,
                        x_pos + cell_size,
                        y_pos + cell_size,
                        fill="gray",
                        outline="black"
                    )