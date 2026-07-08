import AbstractMaze from "./AbstractMaze.js";

export default class Maze extends AbstractMaze {

    constructor(name, width, height) {
        super(width, height);

        this.name = name;

        this.rooms = [];
        this.doors = [];
        this.paths = [];
    }

    addRoom(room) {
        this.rooms.push(room);
    }

    setRooms(rooms) {
        this.rooms = rooms;
    }

    getRooms() {
        return this.rooms;
    }

    addDoor(door) {
        this.doors.push(door);
    }

    addPath(path) {
        this.paths.push(path);
    }

    getDoors() {
        return this.doors;
    }

    getPaths() {
        return this.paths;
    }

}