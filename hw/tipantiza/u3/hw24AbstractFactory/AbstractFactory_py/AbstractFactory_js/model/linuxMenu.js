const Menu = require('./menu.js');

class LinuxMenu extends Menu {
    paint() {
        console.log(`I'm a LinuxMenu: ${this.caption}`);
    }
}

module.exports = LinuxMenu;