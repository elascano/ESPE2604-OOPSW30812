export default class MazePanel {
    constructor(maze, path, cellSize, canvasId) {
        this.maze = maze;
        this.path = path;
        this.cellSize = cellSize;
        this.canvas = document.getElementById(canvasId);
        if (!this.canvas) {
            console.error(`Canvas with id ${canvasId} not found`);
            return;
        }
        
        const w = maze.width * cellSize;
        const h = maze.height * cellSize;
        this.canvas.width = w + cellSize;
        this.canvas.height = h + cellSize;
        this.ctx = this.canvas.getContext('2d');
    }

    paintComponent() {
        if (!this.ctx) return;
        
        const width = this.maze.width;
        const height = this.maze.height;
        const margin = this.cellSize / 2;

        const wallColor = "#4a5568";
        const pathColor = "#ef4444";
        const entranceColor = "#22c55e";
        const exitColor = "#3b82f6";
        const cellBgColor = "#1e293b";
        const bgColor = "#121218";

        // Fill canvas background
        this.ctx.fillStyle = bgColor;
        this.ctx.fillRect(0, 0, this.canvas.width, this.canvas.height);

        // Fill maze background
        this.ctx.fillStyle = cellBgColor;
        this.ctx.fillRect(margin, margin, width * this.cellSize, height * this.cellSize);

        const entrance = this.maze.entrance;
        if (entrance) {
            this.ctx.fillStyle = entranceColor;
            this.ctx.fillRect(margin + entrance.x * this.cellSize, margin + entrance.y * this.cellSize, this.cellSize, this.cellSize);
        }
        
        const exit = this.maze.exit;
        if (exit) {
            this.ctx.fillStyle = exitColor;
            this.ctx.fillRect(margin + exit.x * this.cellSize, margin + exit.y * this.cellSize, this.cellSize, this.cellSize);
        }

        if (this.path && this.path.length > 0) {
            this.ctx.strokeStyle = pathColor;
            this.ctx.lineWidth = Math.max(2, this.cellSize / 4);
            this.ctx.lineCap = 'round';
            this.ctx.lineJoin = 'round';

            this.ctx.beginPath();
            for (let i = 0; i < this.path.length - 1; i++) {
                const c1 = this.path[i];
                const c2 = this.path[i + 1];
                const x1 = margin + c1.x * this.cellSize + this.cellSize / 2;
                const y1 = margin + c1.y * this.cellSize + this.cellSize / 2;
                const x2 = margin + c2.x * this.cellSize + this.cellSize / 2;
                const y2 = margin + c2.y * this.cellSize + this.cellSize / 2;
                
                this.ctx.moveTo(x1, y1);
                this.ctx.lineTo(x2, y2);
            }
            this.ctx.stroke();
        }

        this.ctx.strokeStyle = wallColor;
        this.ctx.lineWidth = Math.max(1, this.cellSize / 10);

        this.ctx.beginPath();
        for (let y = 0; y < height; y++) {
            for (let x = 0; x < width; x++) {
                const cell = this.maze.getCell(x, y);
                if (!cell) continue;

                const cx = margin + x * this.cellSize;
                const cy = margin + y * this.cellSize;

                if (cell.wallNorth) {
                    this.ctx.moveTo(cx, cy);
                    this.ctx.lineTo(cx + this.cellSize, cy);
                }
                if (cell.wallSouth) {
                    this.ctx.moveTo(cx, cy + this.cellSize);
                    this.ctx.lineTo(cx + this.cellSize, cy + this.cellSize);
                }
                if (cell.wallEast) {
                    this.ctx.moveTo(cx + this.cellSize, cy);
                    this.ctx.lineTo(cx + this.cellSize, cy + this.cellSize);
                }
                if (cell.wallWest) {
                    this.ctx.moveTo(cx, cy);
                    this.ctx.lineTo(cx, cy + this.cellSize);
                }
            }
        }
        this.ctx.stroke();
    }
}
