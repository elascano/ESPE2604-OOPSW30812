import readline from 'readline';

class BeverageView {
    constructor() {
        this.rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
    }

    showMessage(message) {
        console.log(message);
    }

    async getUserInput(prompt) {
        return new Promise(resolve => {
            this.rl.question(prompt + " ", (answer) => {
                resolve(answer);
            });
        });
    }

    close() {
        this.rl.close();
    }
}
export default BeverageView;