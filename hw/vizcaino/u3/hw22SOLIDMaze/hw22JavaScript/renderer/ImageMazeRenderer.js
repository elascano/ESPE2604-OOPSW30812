import MazeRenderer from "./MazeRenderer.js";

export default class ImageMazeRenderer extends MazeRenderer {

    constructor() {
        super();
    }

    render(maze, canvas) {
        if (!maze || !canvas) {
            return;
        }

        const context = canvas.getContext("2d");
        context.clearRect(0, 0, canvas.width, canvas.height);

        const roomSize = Math.min(
            canvas.width / maze.width,
            canvas.height / maze.height
        );

        const mazeWidth = maze.width * roomSize;
        const mazeHeight = maze.height * roomSize;

        const offsetX = (canvas.width - mazeWidth) / 2;
        const offsetY = (canvas.height - mazeHeight) / 2;

        const rooms = maze.getRooms();
        rooms.forEach(room => {
            if (room) {
                const x = offsetX + room.getColumn() * roomSize;
                const y = offsetY + room.getRow() * roomSize;
                this.drawRoom(context, room, x, y, roomSize);
            }
        });

        this.drawStart(context, offsetX, offsetY, roomSize);
        this.drawExit(context, maze, offsetX, offsetY, roomSize);
    }

    drawRoom(context, room, x, y, roomSize) {
        context.fillStyle = "#F2F2F2";
        context.fillRect(x, y, roomSize, roomSize);

        context.strokeStyle = "#000000";
        context.lineWidth = 2;

        if (room.north) {
            this.drawWall(context, x, y, x + roomSize, y);
        }
        if (room.south) {
            this.drawWall(context, x, y + roomSize, x + roomSize, y + roomSize);
        }
        if (room.west) {
            this.drawWall(context, x, y, x, y + roomSize);
        }
        if (room.east) {
            this.drawWall(context, x + roomSize, y, x + roomSize, y + roomSize);
        }
    }

    drawWall(context, x1, y1, x2, y2) {
        context.beginPath();
        context.moveTo(x1, y1);
        context.lineTo(x2, y2);
        context.stroke();
    }

    drawStart(context, offsetX, offsetY, roomSize) {
        const size = roomSize * 0.5;
        context.fillStyle = "#2ECC71";
        context.fillRect(
            offsetX + roomSize * 0.25,
            offsetY + roomSize * 0.25,
            size,
            size
        );

        context.fillStyle = "white";
        context.font = `${roomSize * 0.4}px Arial`;
        context.fillText(
            "S",
            offsetX + roomSize * 0.35,
            offsetY + roomSize * 0.65
        );
    }

    drawExit(context, maze, offsetX, offsetY, roomSize) {
        const size = roomSize * 0.5;
        const x = offsetX + (maze.width - 1) * roomSize + roomSize * 0.25;
        const y = offsetY + (maze.height - 1) * roomSize + roomSize * 0.25;

        context.fillStyle = "#E74C3C";
        context.fillRect(x, y, size, size);

        context.fillStyle = "white";
        context.font = `${roomSize * 0.4}px Arial`;
        context.fillText(
            "E",
            x + roomSize * 0.12,
            y + roomSize * 0.4
        );
    }
}