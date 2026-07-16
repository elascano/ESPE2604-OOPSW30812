const MacButton = require('./macButton.js');
const MacMenu = require('./macMenu.js');

class MacFactory {
    createButton() {
        return new MacButton();
    }
    
    createMenu() {
        return new MacMenu();
    }
}

module.exports = MacFactory;