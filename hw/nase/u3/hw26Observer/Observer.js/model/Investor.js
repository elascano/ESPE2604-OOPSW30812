import { IInvestor } from './IInvestor.js';

export class Investor extends IInvestor {
    constructor(name) {
        super();
        this.name = name;
        this.observerState = null;
        this.stock = null;
    }

    update(stock, args) {
        console.log(`Notified observer ${this.name}`);
        
        // En JavaScript validamos si es de tipo String
        if (typeof args === 'string') {
            console.log(`The symbol of ${stock.getSymbol()} changed to: ${args}`);
        } 
        // Validamos si es de tipo Number (equivalente a Double/Float)
        else if (typeof args === 'number') {
            console.log(`The price of ${stock.getSymbol()} changed to: ${args}`);
        }
    }
}