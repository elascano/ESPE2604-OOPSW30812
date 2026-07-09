import readline from 'readline';
import { Maze } from './model/Maze.js';
import { PathController } from './controller/PathController.js';
import { ASCIIPrinter } from './view/ASCIIPrinter.js';
import { MazeGUI } from './view/MazeGUI.js';

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

console.log("=== INITIALIZING JAVASCRIPT MAZE GENERATOR ===");


const maze = new Maze();
maze.generate(4, 4);


const pathController = new PathController();
pathController.findPath(maze);
pathController.verifyPath();


console.log("\nSelect rendering method:");
console.log("1. Print using ASCII characters");
console.log("2. Draw inside an Image (GUI)");

rl.question("Enter your option (1 or 2): ", (answer) => {
    let currentRenderer;

    if (answer.trim() === '1') {
        currentRenderer = new ASCIIPrinter();
    } else if (answer.trim() === '2') {
        currentRenderer = new MazeGUI();
    } else {
        console.log("Invalid option. Defaulting to ASCII.");
        currentRenderer = new ASCIIPrinter();
    }

    
    currentRenderer.render(maze);
    rl.close();
});