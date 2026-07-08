export default class MazePrinter {

    print(maze) {
        console.clear();
        console.log("========== MAZE DATA ==========");

        const rooms = maze.getRooms();
        
        rooms.forEach(room => {
            console.log(
                `Room ${room.id} -> Row: ${room.row} Column: ${room.column}`
            );
        });

        console.log("\n========== TEXT MAZE MAP ==========");

        let topWall = "   " + "_".repeat(maze.width * 2 - 1);
        console.log(topWall);

        for (let row = 0; row < maze.height; row++) {
            let rowString = "  |";
            for (let column = 0; column < maze.width; column++) {
                const room = rooms[row * maze.width + column];

                if (!room) continue;

                if (room.row === 0 && room.column === 0) {
                    rowString += "S";
                } else if (room.row === maze.height - 1 && room.column === maze.width - 1) {
                    rowString += "E";
                } else {
                    rowString += room.south ? "_" : " ";
                }

                if (room.east) {
                    rowString += "|";
                } else {
                    rowString += " ";
                }
            }
            console.log(rowString);
        }
        console.log("===================================");
    }
}