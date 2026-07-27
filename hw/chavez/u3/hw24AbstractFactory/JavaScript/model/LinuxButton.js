const Button = require("./Button");

class LinuxButton extends Button {

    paint() {
        console.log("I am a LinuxButton: " + this.caption);
    }
}

module.exports = LinuxButton;