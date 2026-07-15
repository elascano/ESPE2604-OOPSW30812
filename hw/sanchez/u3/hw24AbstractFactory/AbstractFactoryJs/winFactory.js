const GUIFactory = require("./guiFactory");
const WinButton = require("./winButton");
const WinMenu = require("./winMenu");

class WinFactory extends GUIFactory {
    createButton() {
        return new WinButton();
    }

    createMenu() {
        return new WinMenu();
    }
}

module.exports = WinFactory;