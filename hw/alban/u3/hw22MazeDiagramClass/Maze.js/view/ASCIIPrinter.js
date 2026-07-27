import { MazeRenderer } from './MazeRenderer.js';
export class ASCIIPrinter extends MazeRenderer {
    render(maze) {
        console.log("[View ASCII] Printing maze representation using text characters:");
        console.log("+---+---+---+");
        console.log("S   |       |");
        console.log("+---+   +---+");
        console.log("|       |   E");
        console.log("+---+---+---+");
    }
}