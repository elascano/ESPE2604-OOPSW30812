const Character = require("./character");

class Warrior extends Character {

    attack() {
        console.log(`${this.name} attacks with a sword`);
    }
}

module.exports = Warrior;