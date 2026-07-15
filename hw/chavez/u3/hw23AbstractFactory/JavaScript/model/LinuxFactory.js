const GUIFactory = require("./GUIFactory");
const LinuxButton = require("./LinuxButton");
const LinuxMenu = require("./LinuxMenu");

class LinuxFactory extends GUIFactory {

    createButton() {
        return new LinuxButton();
    }

    createMenu() {
        return new LinuxMenu();
    }
}

module.exports = LinuxFactory;