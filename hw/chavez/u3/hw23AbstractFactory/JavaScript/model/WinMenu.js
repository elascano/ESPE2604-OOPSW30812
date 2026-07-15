const Menu = require("./Menu");

class WinMenu extends Menu {

    paint() {
        console.log("I am a WinMenu: " + this.caption);
    }
}

module.exports = WinMenu;