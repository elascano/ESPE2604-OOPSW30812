const Character = require("./character");

class Mage extends Character {

    attack() {
        console.log(`${this.name} casts a fire spell`);
    }
}

module.exports = Mage;