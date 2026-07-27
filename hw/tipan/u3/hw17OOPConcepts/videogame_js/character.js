class Character {

    constructor(id, name, level, health) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
    }

    displayInfo() {
        console.log(`${this.name} Level: ${this.level} Health: ${this.health}`);
    }

    attack() {
        throw new Error("Method 'attack()' must be implemented");
    }
}

module.exports = Character;