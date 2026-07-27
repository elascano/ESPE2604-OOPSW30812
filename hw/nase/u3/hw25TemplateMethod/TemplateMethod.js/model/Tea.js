import { CaffeineBeverage } from './CaffeineBeverage.js';
import readlineSync from 'readline-sync'; 

// Jennyfer Nase

export class Tea extends CaffeineBeverage {
    brew() {
        console.log("Steep the tea");
    }

    addCondiments() {
        console.log("Adding lemon");
    }

    wantsCondiments() {
        const answer = this.getUserInput();
        return answer.toLowerCase().startsWith('y');
    }

    getUserInput() {
        try {
            const answer = readlineSync.question("Would you like lemon with your tea (y/n)? ");
            return answer || "no";
        } catch (error) {
            console.error("Error reading input.");
            return "no";
        }
    }
}