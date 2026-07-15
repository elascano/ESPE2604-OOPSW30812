const Button = require('./button.js');

class MacButton extends Button {
    paint() {
        console.log(`I'm a MacButton: ${this.caption}`);
    }
}

module.exports = MacButton;