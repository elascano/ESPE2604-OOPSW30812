const Menu = require('./menu.js');

class WinMenu extends Menu {
    paint() {
        console.log(`I'm a WnMenu: ${this.caption}`);
    }
}

module.exports = WinMenu;