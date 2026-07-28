import { Door } from './Door.js';
export class ExitDoor extends Door {
    open() {
        console.log("Opening Exit Door. You have escaped successfully!");
    }
}