// author JEnnyfer Nase
class Chicken {
    constructor(name, age) {
        this.name = name;
        this.age = age;
        this.food = 50;
        this.eggs = 0;
    }

    toString() {
        return `Chicken{name=${this.name}, age=${this.age}, food=${this.food}, eggs=${this.eggs}}`;
    }
}

module.exports = Chicken;