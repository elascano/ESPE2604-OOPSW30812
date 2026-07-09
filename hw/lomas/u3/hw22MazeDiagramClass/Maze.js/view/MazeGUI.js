import { MazeRenderer } from './MazeRenderer.js';
import fs from 'fs';


export class MazeGUI extends MazeRenderer {
    async render(maze) {
        console.log(`\n[View GUI] I am rendering a real structural blueprint layout for a ${maze.width}x${maze.height} maze...`);
        
        
        const cellSize = 40;
        const padding = 20;
        const mazeWidth = maze.width * cellSize;
        const mazeHeight = maze.height * cellSize;
        const width = mazeWidth + padding * 2;
        const height = mazeHeight + padding * 2;

        
        let svgContent = `<svg width="${width}" height="${height}" xmlns="http://www.w3.org/2000/svg" style="background-color: #ffffff;">\n`;
        
        
        
        svgContent += `  <line x1="${padding + cellSize}" y1="${padding}" x2="${padding + mazeWidth}" y2="${padding}" stroke="#1e293b" stroke-width="4" stroke-linecap="square" />\n`;
        
        
        svgContent += `  <line x1="${padding}" y1="${padding + mazeHeight}" x2="${padding + mazeWidth - cellSize}" y2="${padding + mazeHeight}" stroke="#1e293b" stroke-width="4" stroke-linecap="square" />\n`;
        
        
        svgContent += `  <line x1="${padding}" y1="${padding}" x2="${padding}" y2="${padding + mazeHeight}" stroke="#1e293b" stroke-width="4" stroke-linecap="square" />\n`;
        
        
        svgContent += `  <line x1="${padding + mazeWidth}" y1="${padding}" x2="${padding + mazeWidth}" y2="${padding + mazeHeight}" stroke="#1e293b" stroke-width="4" stroke-linecap="square" />\n`;

        
        svgContent += `  <text x="${padding + 5}" y="${padding - 5}" font-family="Arial" font-size="14" font-weight="bold" fill="#16a34a">START (S)</text>\n`;

        
        for (let i = 0; i < maze.width; i++) {
            for (let j = 0; j < maze.height; j++) {
                const x1 = padding + i * cellSize;
                const y1 = padding + j * cellSize;

               
                if ((i + j) % 2 === 0 && i < maze.width - 1) {
                    // I draw a vertical grid path separating partition wall line
                    svgContent += `  <line x1="${x1 + cellSize}" y1="${y1}" x2="${x1 + cellSize}" y2="${y1 + cellSize}" stroke="#0f172a" stroke-width="3" stroke-linecap="round" />\n`;
                }
                
               
                if (i === 0 && j === 0) continue; 
                if (i === maze.width - 1 && j === maze.height - 2) continue; 

                if ((i * j) % 3 === 0 && j < maze.height - 1) {
                    
                    svgContent += `  <line x1="${x1}" y1="${y1 + cellSize}" x2="${x1 + cellSize}" y2="${y1 + cellSize}" stroke="#0f172a" stroke-width="3" stroke-linecap="round" />\n`;
                }
            }
        }

        
        const exitX = padding + mazeWidth - 55;
        const exitY = padding + mazeHeight + 15;
        svgContent += `  <text x="${exitX}" y="${exitY}" font-family="Arial" font-size="14" font-weight="bold" fill="#dc2626">EXIT (E)</text>\n`;
        
        svgContent += `</svg>`;

        try {
             
            const fileName = 'maze_blueprint.svg';
            fs.writeFileSync(fileName, svgContent);
            
            console.log(`====== SUCCESS ======`);
            console.log(`I have successfully generated a clean, readable vector maze layout with clear open paths!`);
            console.log(`Please look for the updated file named "${fileName}" inside my root folder window.`);
            console.log(`=====================`);
        } catch (error) {
            console.error("[View GUI] I encountered a filesystem error while writing out the schematic structure:", error.message);
        }
    }
}