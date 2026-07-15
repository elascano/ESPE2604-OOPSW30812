const Button = require("./button");

class MacButton extends Button {
    paint() {
        console.log(`I'm a MacOS Button: ${this.caption}`);
    }
}

module.exports = MacButton;