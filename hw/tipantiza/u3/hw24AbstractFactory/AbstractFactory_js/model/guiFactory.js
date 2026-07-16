const ConfigReader = require('../controller/configReader.js');

class GUIFactory {
    
    static getFactory() {
        const sysType = ConfigReader.getOsType();
        if (sysType === 0) {
            const WinFactory = require('./winFactory.js');
            return new WinFactory();
        } else if (sysType === 2) {
            const MacFactory = require('./macFactory.js');
            return new MacFactory();
        } else {
            const LinuxFactory = require('./linuxFactory.js');
            return new LinuxFactory();
        }
    }
    
    createButton() {
        throw new Error("Method 'createButton()' must be implemented");
    }
    
    createMenu() {
        throw new Error("Method 'createMenu()' must be implemented");
    }
}

module.exports = GUIFactory;