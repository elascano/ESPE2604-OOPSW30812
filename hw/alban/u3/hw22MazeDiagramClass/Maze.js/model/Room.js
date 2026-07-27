export class Room {
    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.doors = [];
        this.walls = [];
    }

    addDoor(door) { this.doors.push(door); }
    addWall(wall) { this.walls.push(wall); }
}