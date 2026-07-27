import { CaffeineBeverage } from './CaffeineBeverage.js';
import readlineSync from 'readline-sync';

// Jennyfer Nase

export class Coffee extends CaffeineBeverage {
    brew() {
        console.log("Dripping coffee through filter");
    }

    addCondiments() {
        console.log("Adding sugar and milk");
    }

    wantsCondiments() {
        const answer = this.getUserInput();
        return answer.toLowerCase().startsWith('y');
    }

    getUserInput() {
        try {
            const answer = readlineSync.question("Would you like milk and sugar with your coffee (y/n)? ");
            return answer || "no";
        } catch (error) {
            console.error("Error reading input.");
            return "no";
        }
    }
}