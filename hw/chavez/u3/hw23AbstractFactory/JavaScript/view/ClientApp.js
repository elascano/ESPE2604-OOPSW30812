const GUIController = require("../controller/GUIController");

class ClientApp {

    run() {
        const controller = new GUIController();
        controller.start();
    }
}

const app = new ClientApp();
app.run();