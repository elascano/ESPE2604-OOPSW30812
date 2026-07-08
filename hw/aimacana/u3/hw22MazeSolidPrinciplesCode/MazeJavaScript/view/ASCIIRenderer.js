import BaseRenderer from './BaseRenderer.js';

export default class ASCIIRenderer extends BaseRenderer {
    draw(maze, path) {
        super.draw(maze, path);
        const width = maze.width;
        const height = maze.height;

        const isPath = Array.from({ length: height }, () => Array(width).fill(false));
        if (path) {
            for (const cell of path) {
                isPath[cell.y][cell.x] = true;
            }
        }

        let output = "";

        for (let y = 0; y < height; y++) {
            let topLine = "";
            for (let x = 0; x < width; x++) {
                const cell = maze.getCell(x, y);
                topLine += cell.wallNorth ? "+---" : "+   ";
            }
            output += topLine + "+\n";

            let sideLine = "";
            for (let x = 0; x < width; x++) {
                const cell = maze.getCell(x, y);
                let char = " ";
                if (cell === maze.entrance) {
                    char = "S";
                } else if (cell === maze.exit) {
                    char = "E";
                } else if (isPath[y][x]) {
                    char = "*";
                }
                sideLine += cell.wallWest ? "| " + char + " " : "  " + char + " ";
            }
            output += sideLine + "|\n";
        }

        let bottomLine = "";
        for (let x = 0; x < width; x++) {
            bottomLine += "+---";
        }
        output += bottomLine + "+\n";

        console.log(output);
        return output; // Return so we can render it in HTML too if needed
    }
}
