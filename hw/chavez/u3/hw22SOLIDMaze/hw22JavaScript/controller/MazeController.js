import Maze from "../model/Maze.js";
import MazeGeneratorAlgorithm from "../generator/MazeGeneratorAlgorithm.js";
import ImageMazeRenderer from "../renderer/ImageMazeRenderer.js";
import MazePrinter from "../renderer/MazePrinter.js";
import MazeView from "../view/MazeView.js";

export default class MazeController {

    constructor(
        view = new MazeView(),
        generator = new MazeGeneratorAlgorithm(),
        renderer = new ImageMazeRenderer(),
        printer = new MazePrinter()
    ) {
        this.view = view;
        this.generator = generator;
        this.renderer = renderer;
        this.printer = printer;
        this.maze = null;
    }

    initialize() {
        this.view.onGenerateMaze(() => this.generateMaze());
        this.view.onPrintMaze(() => this.printMaze());
        this.view.onSaveMaze(() => this.saveMazeImage());
    }

    generateMaze() {
        try {
            const width = this.view.getWidth();
            const height = this.view.getHeight();

            this.validateDimensions(width, height);

            this.maze = new Maze("Maze System", width, height);

            this.generator.generate(this.maze);

            this.renderer.render(this.maze, this.view.getCanvas());

            this.view.showMessage(
                `Maze generated successfully (${width} × ${height}).`
            );

        } catch (error) {
            this.view.showMessage(error.message);
        }
    }

    printMaze() {

        if (!this.hasMaze()) return;

        this.printer.print(this.maze);

        this.view.showMessage("Maze printed to console.");
    }

    saveMazeImage() {

        if (!this.hasMaze()) return;

        const canvas = this.view.getCanvas();

        const link = document.createElement("a");
        link.download = "maze.png";
        link.href = canvas.toDataURL("image/png");
        link.click();

        this.view.showMessage("Maze image saved successfully.");
    }

    validateDimensions(width, height) {

        if (!Number.isInteger(width) || width <= 0) {
            throw new Error("Width must be greater than zero.");
        }

        if (!Number.isInteger(height) || height <= 0) {
            throw new Error("Height must be greater than zero.");
        }
    }

    hasMaze() {

        if (this.maze !== null) {
            return true;
        }

        this.view.showMessage("Generate a maze first.");

        return false;
    }

    getMaze() {
        return this.maze;
    }

}