
import { BacktrackingMazeGenerator } from '../model/MazeGenerator.js';
import { DFSMazeSolver } from '../model/MazeSolver.js';
import { GUIView } from '../view/MazeView.js';

export class MazeController {
    constructor() {
        this.generator = new BacktrackingMazeGenerator();
        this.solver = new DFSMazeSolver();
        this.view = new GUIView();
        
        document.getElementById('generateBtn').addEventListener('click', () => this.generate());
        this.generate(); // initial render
    }
    
    generate() {
        let w = parseInt(document.getElementById('widthInput').value, 10);
        let h = parseInt(document.getElementById('heightInput').value, 10);
        if(w > 100) w = 100;
        if(h > 100) h = 100;
        
        const maze = this.generator.generate(w, h);
        const path = this.solver.solve(maze);
        this.view.render(maze, path);
    }
}
