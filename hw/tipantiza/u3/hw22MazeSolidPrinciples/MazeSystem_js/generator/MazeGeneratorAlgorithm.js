import MazeGenerator from "./MazeGenerator.js"; 
import Room from "../model/Room.js";
import Door from "../model/Door.js";
import Path from "../model/Path.js";

export default class MazeGeneratorAlgorithm extends MazeGenerator {

    generate(maze) {
        maze.rooms = [];
        maze.doors = [];
        maze.paths = [];

        let id = 1;

        for (let row = 0; row < maze.height; row++) {
            for (let column = 0; column < maze.width; column++) {
                const room = new Room(id++, row, column);
                maze.addRoom(room);
            }
        }

        for (let row = 0; row < maze.height; row++) {
            for (let column = 0; column < maze.width; column++) {
                const current = maze.rooms[row * maze.width + column];

                if (column < maze.width - 1) {
                    const right = maze.rooms[row * maze.width + column + 1];
                    maze.addPath(new Path(current, right));
                    maze.addDoor(new Door(current, right));
                }

                if (row < maze.height - 1) {
                    const down = maze.rooms[(row + 1) * maze.width + column];
                    maze.addPath(new Path(current, down));
                    maze.addDoor(new Door(current, down));
                }
            }
        }
    }
}