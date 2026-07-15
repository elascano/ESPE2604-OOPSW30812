const LinuxButton = require('./linuxButton.js');
const LinuxMenu = require('./linuxMenu.js');

class LinuxFactory {
    createButton() {
        return new LinuxButton();
    }
    
    createMenu() {
        return new LinuxMenu();
    }
}

module.exports = LinuxFactory;