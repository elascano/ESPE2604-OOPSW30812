/**
 * @author Cristian Palomo, Error 404, @ESPE
 */
import { Investor } from "./Investor.js";
import { StockView } from "../view/StockView.js";

export class Financier extends Investor {
    constructor(name) {
        super();
        this.name = name;
        this.observerState = undefined;
        this.stock = undefined;
    }

    update(stock, args) {
        this.stock = stock;
        StockView.printNotification(this.name, stock, args);
    }
}
