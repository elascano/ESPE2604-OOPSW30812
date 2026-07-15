const Button = require("./button");

class WinButton extends Button {
    paint() {
        console.log(`I'm a Windows Button: ${this.caption}`);
    }
}

module.exports = WinButton;