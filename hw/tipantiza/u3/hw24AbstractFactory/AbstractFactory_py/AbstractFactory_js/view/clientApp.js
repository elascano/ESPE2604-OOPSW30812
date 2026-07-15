const ConfigReader = require('../controller/configReader.js');
const GUIFactory = require('../model/guiFactory.js');

class ClientApp {
    
    static main() {
        console.log("=== Abstract Factory Pattern Demo ===");
        console.log(`Operating System: ${ConfigReader.getOperatingSystemName()}`);
        console.log("----------------------------------------");
        
        const aFactory = GUIFactory.getFactory();
        
        const aButton = aFactory.createButton();
        aButton.caption = "play";
        aButton.paint();
        
        const aMenu = aFactory.createMenu();
        aMenu.caption = "Main Menu";
        aMenu.paint();
        
        console.log("----------------------------------------");
        
        const anotherButton = aFactory.createButton();
        anotherButton.caption = "stop";
        anotherButton.paint();
        
        const anotherMenu = aFactory.createMenu();
        anotherMenu.caption = "Context Menu";
        anotherMenu.paint();
    }
}

ClientApp.main();