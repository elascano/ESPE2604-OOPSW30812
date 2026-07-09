import { Door } from './Door.js';

export class EntranceDoor extends Door {
    open() {
        console.log("Opening Entrance Door. Welcome to the maze!");
    }
}