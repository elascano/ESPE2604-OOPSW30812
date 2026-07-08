export class Door {
    constructor(room1, room2, direction) {
        if (this.constructor === Door) {
            throw new Error("Abstract class 'Door' cannot be instantiated directly.");
        }
        this.room1 = room1;
        this.room2 = room2;
        this.direction = direction;
    }

    open() {
        throw new Error("Method 'open()' must be implemented by subclasses.");
    }
}