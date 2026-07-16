const Button = require('./button.js');

class WinButton extends Button {
    paint() {
        console.log(`I'm a WnButton: ${this.caption}`);
    }
}

module.exports = WinButton;