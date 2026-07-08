export default class AbstractMaze {

    constructor(width, height) {
        if (new.target === AbstractMaze) {
            throw new Error("AbstractMaze cannot be instantiated.");
        }

        this.width = width;
        this.height = height;
    }

    generate() {
        throw new Error("Method generate() must be implemented.");
    }

}