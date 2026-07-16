const { Menu } = require('./menu.js');

class LinuxMenu extends Menu {
    paint() {
        return "I'm a LinuxMenu: " + this.caption;
    }
}

module.exports = { LinuxMenu };