import readline from 'readline';

export class ConsoleView {

    constructor() {

        this.readlineInterface =
            readline.createInterface({
                input: process.stdin,
                output: process.stdout
            });
    }

    ask(question) {

        return new Promise(resolve =>
            this.readlineInterface.question(
                question,
                resolve
            )
        );
    }

    showMenu() {

        console.log("\n=== SD CARD MENU ===");

        console.log("1. Create");
        console.log("2. View All");
        console.log("3. Search");
        console.log("4. Delete");
        console.log("5. Exit");
    }

    close() {

        this.readlineInterface.close();
    }
}