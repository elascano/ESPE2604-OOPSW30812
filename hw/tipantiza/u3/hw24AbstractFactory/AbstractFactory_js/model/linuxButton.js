const Button = require('./button.js');

class LinuxButton extends Button {
    paint() {
        console.log(`I'm a LinuxButton: ${this.caption}`);
    }
}

module.exports = LinuxButton;