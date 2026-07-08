import BaseRenderer from './BaseRenderer.js';
import MazePanel from './MazePanel.js';

export default class ImageRenderer extends BaseRenderer {
    constructor(cellSize = 20, canvasId = 'mazeCanvas') {
        super();
        this.cellSize = cellSize;
        this.canvasId = canvasId;
    }

    draw(maze, path) {
        super.draw(maze, path);

        let calculatedCellSize = this.cellSize;
        if (maze.width > 100 || maze.height > 100) {
            calculatedCellSize = Math.max(4, Math.floor(800 / Math.max(maze.width, maze.height)));
        }

        const panel = new MazePanel(maze, path, calculatedCellSize, this.canvasId);
        panel.paintComponent();
    }
}
