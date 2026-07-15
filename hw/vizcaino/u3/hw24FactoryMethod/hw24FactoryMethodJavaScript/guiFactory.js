class GUIFactory {
    constructor() {
        if (this.constructor === GUIFactory) {
            throw new Error("Cannot instantiate abstract class GUIFactory");
        }
    }

    static getFactory() {
        const sys = GUIFactory.readFromConfigFile("OS_TYPE");
        if (sys === 0) {
            const WinFactory = require('./winFactory');
            return new WinFactory();
        } else {
            const LinuxFactory = require('./linuxFactory');
            return new LinuxFactory();
        }
    }

    static readFromConfigFile(key) {
        return 0;
    }

    createButton() {
        throw new Error("Method 'createButton()' must be implemented.");
    }

    createMenu() {
        throw new Error("Method 'createMenu()' must be implemented.");
    }
}

module.exports = GUIFactory;