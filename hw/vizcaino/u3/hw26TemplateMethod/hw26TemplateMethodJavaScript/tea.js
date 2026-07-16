const CaffeinBeverage = require('./caffeinBeverage');
const readline = require('readline');

class Tea extends CaffeinBeverage {
    brew() {
        console.log("Steep the tea");
    }

    addCondiments() {
        console.log("Adding lemon");
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
            rl.question("Would you like lemon with your tea (y/n)? ", (answer) => {
                rl.close();
                resolve(answer || "n");
            });
        });
    }
}

module.exports = Tea;