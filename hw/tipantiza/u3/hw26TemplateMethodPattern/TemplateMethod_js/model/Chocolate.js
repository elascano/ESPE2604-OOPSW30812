const CaffeineBeverage = require('./CaffeineBeverage');
const readline = require('readline');

class Chocolate extends CaffeineBeverage {
    brew() {
        console.log("Mixing chocolate powder with hot water");
    }

    addCondiments() {
        console.log("Adding whipped cream");
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
            rl.question("Would you like whipped cream with your chocolate (y/n)? ", (answer) => {
                rl.close();
                resolve(answer);
            });
        });
    }
}

module.exports = Chocolate;