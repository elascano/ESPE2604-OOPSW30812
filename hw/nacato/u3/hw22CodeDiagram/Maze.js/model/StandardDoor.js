import { Door } from './Door.js';
export class StandardDoor extends Door {
    open() {
        console.log("Opening Standard Door to an adjoining room.");
    }
}