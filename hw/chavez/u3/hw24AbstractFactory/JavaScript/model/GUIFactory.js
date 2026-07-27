class GUIFactory {

    static getFactory() {

        if (process.platform === "win32") {
            const WinFactory = require("./WinFactory");
            return new WinFactory();
        } else {
            const LinuxFactory = require("./LinuxFactory");
            return new LinuxFactory();
        }
    }

    createButton() {}

    createMenu() {}
}

module.exports = GUIFactory;