const Button = require("./Button");

class WinButton extends Button {

    paint() {
        console.log("I'm a WinButton: " + this.caption);
    }
}

module.exports = WinButton;