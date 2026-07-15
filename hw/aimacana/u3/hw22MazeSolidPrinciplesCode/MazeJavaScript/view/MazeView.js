
import { Direction } from '../model/Direction.js';

export class IMazeView {
    render(maze, path) { throw new Error('Method not implemented.'); }
}

export class GUIView extends IMazeView {
    constructor() {
        super();
        this.canvas = document.getElementById('mazeCanvas');
        this.ctx = this.canvas.getContext('2d');
        this.ascii = document.getElementById('mazeAscii');
    }

    render(maze, path) {
        const w = maze.width;
        const h = maze.height;
        const cellSize = Math.min(32, Math.max(12, 600 / Math.max(w, h))); 
        
        this.canvas.width = w * cellSize;
        this.canvas.height = h * cellSize;
        
        this.ctx.fillStyle = '#0f172a';
        this.ctx.fillRect(0, 0, this.canvas.width, this.canvas.height);
        
        this.ctx.fillStyle = 'rgba(16, 185, 129, 0.4)';
        this.ctx.fillRect(0, 0, cellSize, cellSize);
        this.ctx.fillStyle = 'rgba(239, 68, 68, 0.4)';
        this.ctx.fillRect((w-1)*cellSize, (h-1)*cellSize, cellSize, cellSize);
        
        if (path && path.length > 0) {
            this.ctx.beginPath();
            this.ctx.strokeStyle = '#eab308';
            this.ctx.lineWidth = Math.max(2, cellSize/5);
            this.ctx.lineCap = 'round';
            this.ctx.lineJoin = 'round';
            this.ctx.moveTo(path[0].x * cellSize + cellSize/2, path[0].y * cellSize + cellSize/2);
            for (let i = 1; i < path.length; i++) {
                this.ctx.lineTo(path[i].x * cellSize + cellSize/2, path[i].y * cellSize + cellSize/2);
            }
            this.ctx.stroke();
        }

        this.ctx.strokeStyle = '#64748b';
        this.ctx.lineWidth = 2;
        this.ctx.lineCap = 'round';
        this.ctx.beginPath();
        for (let y = 0; y < h; y++) {
            for (let x = 0; x < w; x++) {
                const room = maze.getRoom(x, y);
                const px = x * cellSize, py = y * cellSize;
                
                if (!room.hasDoor(Direction.NORTH) && !(room.isEntrance && y === 0)) this.ctx.moveTo(px, py), this.ctx.lineTo(px + cellSize, py);
                if (!room.hasDoor(Direction.WEST)) this.ctx.moveTo(px, py), this.ctx.lineTo(px, py + cellSize);
                if (x === w - 1) this.ctx.moveTo(px + cellSize, py), this.ctx.lineTo(px + cellSize, py + cellSize);
                if (y === h - 1 && !(room.isExit && x === w - 1)) this.ctx.moveTo(px, py + cellSize), this.ctx.lineTo(px + cellSize, py + cellSize);
            }
        }
        this.ctx.stroke();
        
        this.ctx.font = `bold ${cellSize * 0.5}px sans-serif`;
        this.ctx.textAlign = 'center';
        this.ctx.textBaseline = 'middle';
        this.ctx.fillStyle = '#10b981';
        this.ctx.fillText('S', cellSize/2, cellSize/2);
        this.ctx.fillStyle = '#ef4444';
        this.ctx.fillText('E', (w-1)*cellSize + cellSize/2, (h-1)*cellSize + cellSize/2);

        let text = '';
        for (let y = 0; y < h; y++) {
            let topRow = '', midRow = '';
            for (let x = 0; x < w; x++) {
                const r = maze.getRoom(x, y);
                topRow += '+' + (r.hasDoor(Direction.NORTH) || (r.isEntrance && y === 0) ? '   ' : '---');
                midRow += (r.hasDoor(Direction.WEST) ? ' ' : '|');
                if (r.isEntrance) midRow += ' <span style="color:#10b981;font-weight:bold">S</span> ';
                else if (r.isExit) midRow += ' <span style="color:#ef4444;font-weight:bold">E</span> ';
                else if (path.includes(r)) midRow += ' · ';
                else midRow += '   ';
            }
            topRow += '+<br>';
            midRow += '|<br>';
            text += topRow + midRow;
        }
        let bottomRow = '';
        for (let x = 0; x < w; x++) {
            const r = maze.getRoom(x, h-1);
            bottomRow += '+' + (r.hasDoor(Direction.SOUTH) || (r.isExit && x === w-1) ? '   ' : '---');
        }
        text += bottomRow + '+';
        this.ascii.innerHTML = text;
    }
}
