const Menu = require("./menu");

class WinMenu extends Menu {
    paint() {
        console.log(`I'm a Windows Menu: ${this.caption}`);
    }
}

module.exports = WinMenu;