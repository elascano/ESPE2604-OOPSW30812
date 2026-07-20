import { StockView } from '../view/stockView.js';

export class Investor {
    constructor(name) {
        this.name = name;
        this.observerState = "";
        this.stock = null;
    }

    update(stock, args) {
        this.stock = stock;
        StockView.printNotification(this.name, stock, args);
    }
}