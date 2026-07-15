const Menu = require("./menu");

class LinuxMenu extends Menu {
    paint() {
        console.log(`I'm a Linux Menu: ${this.caption}`);
    }
}

module.exports = LinuxMenu;