const Character = require("./character");

class Archer extends Character {

    attack() {
        console.log(`${this.name} shoots an arrow`);
    }
}

module.exports = Archer;