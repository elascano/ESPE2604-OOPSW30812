const GUIFactory = require("./guiFactory");
const MacButton = require("./macButton");
const MacMenu = require("./macMenu");

class MacFactory extends GUIFactory {
    createButton() {
        return new MacButton();
    }

    createMenu() {
        return new MacMenu();
    }
}

module.exports = MacFactory;