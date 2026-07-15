const Menu = require('./menu.js');

class MacMenu extends Menu {
    paint() {
        console.log(`I'm a MacMenu: ${this.caption}`);
    }
}

module.exports = MacMenu;