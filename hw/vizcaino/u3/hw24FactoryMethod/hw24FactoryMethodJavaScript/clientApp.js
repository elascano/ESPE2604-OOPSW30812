const GUIFactory = require('./guiFactory');

class ClientApp {
    static main() {
        const aFactory = GUIFactory.getFactory();
        const aButton = aFactory.createButton();
        aButton.caption = "Play";
        aButton.paint();
    }
}

ClientApp.main();