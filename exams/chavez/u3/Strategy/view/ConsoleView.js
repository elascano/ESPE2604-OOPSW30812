const SortController = require("../controller/SortController");
const readline = require("readline");

class ConsoleView {

    constructor() {
        this.controller = new SortController();

        this.rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
    }

    start() {

        this.rl.question("Enter the numbers separated by commas: ", async (input) => {

            const numbers = input
                .split(",")
                .map(number => Number(number.trim()));

            const model = await this.controller.sort(numbers);

            console.log("\nOriginal Array :", model.getNumbers());
            console.log("Size           :", model.getSize());
            console.log("Algorithm      :", model.getAlgorithm());
            console.log("Sorted Array   :", model.getSortedNumbers());

            this.rl.close();
        });

    }

}

module.exports = ConsoleView;