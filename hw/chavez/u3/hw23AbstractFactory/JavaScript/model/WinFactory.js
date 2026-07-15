const GUIFactory = require("./GUIFactory");
const WinButton = require("./WinButton");
const WinMenu = require("./WinMenu");

class WinFactory extends GUIFactory {

    createButton() {
        return new WinButton();
    }

    createMenu() {
        return new WinMenu();
    }
}

module.exports = WinFactory;