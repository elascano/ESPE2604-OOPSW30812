import MazeController from './controller/MazeController.js';
import DFSGenerator from './service/DFSGenerator.js';
import DFSSolver from './service/DFSSolver.js';
import ASCIIRenderer from './view/ASCIIRenderer.js';
import ImageRenderer from './view/ImageRenderer.js';

document.addEventListener('DOMContentLoaded', () => {
    const generateBtn = document.getElementById('generateBtn');
    const widthInput = document.getElementById('widthInput');
    const heightInput = document.getElementById('heightInput');
    const rendererSelect = document.getElementById('rendererSelect');
    
    const canvas = document.getElementById('mazeCanvas');
    const asciiPre = document.getElementById('asciiOutput');

    generateBtn.addEventListener('click', () => {
        const width = parseInt(widthInput.value, 10);
        const height = parseInt(heightInput.value, 10);
        const rendererType = rendererSelect.value;

        if (isNaN(width) || isNaN(height) || width <= 0 || height <= 0) {
            alert("Dimensions must be positive integers");
            return;
        }

        try {
            let renderer;
            if (rendererType === "Graphical Window") {
                canvas.style.display = 'block';
                asciiPre.style.display = 'none';
                renderer = new ImageRenderer(20, 'mazeCanvas');
            } else {
                canvas.style.display = 'none';
                asciiPre.style.display = 'block';
                
                // We wrap ASCIIRenderer slightly to print to the <pre> tag instead of just console.log
                class DOMASCIIRenderer extends ASCIIRenderer {
                    draw(maze, path) {
                        const out = super.draw(maze, path);
                        asciiPre.textContent = out;
                    }
                }
                renderer = new DOMASCIIRenderer();
            }

            const controller = new MazeController(new DFSGenerator(), new DFSSolver(), renderer);
            controller.createAndShowMaze(width, height);
            
        } catch (e) {
            alert("Error running maze: " + e.message);
            console.error(e);
        }
    });
});
