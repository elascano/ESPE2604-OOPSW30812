const CaffeineBeverage = require('./CaffeineBeverage');
const readline = require('readline');

class Coffee extends CaffeineBeverage {
    brew() {
        console.log("Dripping coffee through filter");
    }

    addCondiments() {
        console.log("Adding sugar and milk");
    }

    async wantsCondiments() {
        const answer = await this.getUserInput();
        return answer.toLowerCase().startsWith('y');
    }

    getUserInput() {
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        return new Promise((resolve) => {
            rl.question("Would you like milk and sugar with your coffee (y/n)? ", (answer) => {
                rl.close();
                resolve(answer);
            });
        });
    }
}

module.exports = Coffee;