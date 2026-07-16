const CaffeinBeverage = require('./caffeinBeverage');
const readline = require('readline');

class Coffee extends CaffeinBeverage {
    brew() {
        console.log("Dripping coffee through filter");
    }

    addCondiments() {
        console.log("Adding sugar and milk");
    }

    async wantsCondiments() {
        const answer = await this.getUserInput();
        return answer.toLowerCase().startsWith("y");
    }

    getUserInput() {
        return new Promise((resolve) => {
            const rl = readline.createInterface({
                input: process.stdin,
                output: process.stdout
            });
            rl.question("Would you like milk and sugar with your coffee (y/n)? ", (answer) => {
                rl.close();
                resolve(answer || "n");
            });
        });
    }
}

module.exports = Coffee;