const readline = require('readline');


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

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

console.log("Chicken Facts");

rl.question("Enter Chicken Name: ", (name) => {
    rl.question("Enter age (months): ", (age) => {
        
        
        const myChicken = new Chicken(name, parseInt(age));

        console.log(`\n[${myChicken.name}] says: CLUCK CLUCK CLUCK!`);
        console.log(`My Chicken is ---->${myChicken.toString()}`);

        rl.close();
    });
});