import MazeController from "./controller/MazeController.js";

class MazeApplication {

    constructor() {
        this.controller = new MazeController();
    }

    start() {
        this.controller.initialize();
    }

}

document.addEventListener("DOMContentLoaded", () => {

    const application = new MazeApplication();

    application.start();

});