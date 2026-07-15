const Menu = require("./menu");

class MacMenu extends Menu {
    paint() {
        console.log(`I'm a MacOS Menu: ${this.caption}`);
    }
}

module.exports = MacMenu;