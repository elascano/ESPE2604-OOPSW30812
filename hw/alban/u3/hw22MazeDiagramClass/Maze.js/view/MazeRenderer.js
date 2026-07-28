export class MazeRenderer {
    constructor() {
        if (this.constructor === MazeRenderer) {
            throw new Error("Interface 'MazeRenderer' cannot be instantiated.");
        }
    }

    render(maze) {
        throw new Error("Method 'render(maze)' must be implemented.");
    }
}