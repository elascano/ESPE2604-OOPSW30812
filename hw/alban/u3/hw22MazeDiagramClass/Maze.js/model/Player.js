export class Player {
    constructor(startingRoom) {
        this.currentRoom = startingRoom;
    }

    move(direction) {
        console.log(`Player command: Moving towards ${direction}`);
    }
}