const GUIFactory = require("./guiFactory");
const LinuxButton = require("./linuxButton");
const LinuxMenu = require("./linuxMenu");

class LinuxFactory extends GUIFactory {
    createButton() {
        return new LinuxButton();
    }

    createMenu() {
        return new LinuxMenu();
    }
}

module.exports = LinuxFactory;