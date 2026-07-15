const Button = require("./button");

class LinuxButton extends Button {
    paint() {
        console.log(`I'm a Linux Button: ${this.caption}`);
    }
}

module.exports = LinuxButton;