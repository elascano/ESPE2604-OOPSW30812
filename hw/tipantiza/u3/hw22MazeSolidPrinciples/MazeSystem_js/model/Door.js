export default class Door {

    constructor(roomA, roomB) {

        this.roomA = roomA;
        this.roomB = roomB;

        this.open = true;

    }

    openDoor() {
        this.open = true;
    }

    closeDoor() {
        this.open = false;
    }

    isOpen() {
        return this.open;
    }

}