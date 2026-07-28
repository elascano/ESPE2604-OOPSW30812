import { Room } from './Room.js';

export class Maze {
    constructor() {
        this.width = 0;
        this.height = 0;
        this.rooms = [];
    }

    generate(width, height) {
        this.width = width;
        this.height = height;
        console.log(`Generating data structure for an ${width}x${height} maze...`);
        
        for (let i = 0; i < width; i++) {
            for (let j = 0; j < height; j++) {
                this.rooms.push(new Room(i, j));
            }
        }
    }
}