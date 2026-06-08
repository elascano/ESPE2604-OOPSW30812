/**
 * Stock Minimum Alert Module
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */

class StockMinAlert {
    static #minStock = 10;
    static #maxStock = 100;
    
    static showMenu() {
        console.log("\n--- STOCK ALERTS ---");
        console.log("1. Configure minimum stock");
        console.log("2. Configure maximum stock");
        console.log("3. Generate alert");
        console.log("4. Record movement");
        console.log("5. View current stock");
        console.log("0. Exit");
    }
    
    static executeOption(option) {
        switch(option) {
            case "1": this.configureMinimum(); break;
            case "2": this.configureMaximum(); break;
            case "3": this.generateAlert(); break;
            case "4": this.recordMovement(); break;
            case "5": this.viewCurrentStock(); break;
            default: console.log("Invalid option");
        }
    }
    
    static configureMinimum() {
        const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });
        
        readline.question("Enter minimum stock value: ", (value) => {
            this.#minStock = parseInt(value);
            console.log(`Minimum stock configured to: ${this.#minStock}`);
            readline.close();
        });
    }
    
    static configureMaximum() {
        const readline = require('readline').createInterface({
            input: process.stdin,
            output: process.stdout
        });
        
        readline.question("Enter maximum stock value: ", (value) => {
            this.#maxStock = parseInt(value);
            console.log(`Maximum stock configured to: ${this.#maxStock}`);
            readline.close();
        });
    }
    
    static generateAlert() {
        console.log(`Stock alert generated. Min: ${this.#minStock}, Max: ${this.#maxStock}`);
    }
    
    static recordMovement() {
        console.log("Movement recorded");
    }
    
    static viewCurrentStock() {
        console.log(`Current stock: 100 units (Min: ${this.#minStock}, Max: ${this.#maxStock})`);
    }
}

module.exports = { StockMinAlert };