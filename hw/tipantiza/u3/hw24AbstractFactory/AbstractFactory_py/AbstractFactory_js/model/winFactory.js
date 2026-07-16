const WinButton = require('./winButton.js');
const WinMenu = require('./winMenu.js');

class WinFactory {
    createButton() {
        return new WinButton();
    }
    
    createMenu() {
        return new WinMenu();
    }
}

module.exports = WinFactory;