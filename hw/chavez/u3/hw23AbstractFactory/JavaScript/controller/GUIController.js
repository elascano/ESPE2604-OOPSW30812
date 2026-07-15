const GUIFactory = require("../model/GUIFactory");

class GUIController {

    start() {

        const factory = GUIFactory.getFactory();

        const button = factory.createButton();
        button.caption = "Play";
        button.paint();

        const menu = factory.createMenu();
        menu.caption = "File";
        menu.paint();
    }
}

module.exports = GUIController;