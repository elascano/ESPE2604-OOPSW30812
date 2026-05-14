/**
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

import readline from 'readline';
import Chicken from '../ec.edu.espe.chickenfarm.model/Chicken.js';

class ChickenFarmSimulator {
    constructor() {
        this.chickens = [];
        this.maxChickens = 100;
        this.rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });
    }

    askQuestion(query) {
        return new Promise(resolve => this.rl.question(query, resolve));
    }

    async run() {
        let counter = 0;
            
        console.log("\nCHICKEN FARM SIMULATOR");

        while (counter < this.maxChickens) {
            console.log(`\nEnter Chicken ${counter + 1}`);
            
            let id = parseInt(await this.askQuestion("Enter id: "));
            let name = await this.askQuestion("Enter name: ");
            let color = await this.askQuestion("Enter color: ");
            let year = parseInt(await this.askQuestion("Enter year: "));
            let month = parseInt(await this.askQuestion("Enter month (0-11): "));
            let day = parseInt(await this.askQuestion("Enter day: "));
            let bornOnDate = new Date(year, month, day);
            let age = parseInt(await this.askQuestion("Enter age: "));
            let isMoltingInput = await this.askQuestion("Is molting? (true/false): ");
            let isMolting = isMoltingInput.toLowerCase() === 'true';

            const chicken = new Chicken(id, name, color, bornOnDate, age, isMolting);
            this.chickens.push(chicken);
            counter++;

            let response = await this.askQuestion("\nDo you want to enter another chicken? (y/n): ");
            if (response.toLowerCase() !== 'y') {
                break;
            }
        }

        console.log("\n List of Registered Chickens\n");
        for (let i = 0; i < counter; i++) {
            console.log(`name --> ${this.chickens[i].getName()}`);
            console.log(`chicken [${i + 1}]${this.chickens[i].toString()}`);
        }

        console.log(`\nTotal registered chickens: ${counter}`);
        this.rl.close();
    }
}

export default ChickenFarmSimulator;