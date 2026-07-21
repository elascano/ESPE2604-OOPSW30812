import { Stock } from './stock.js';

export class IBM extends Stock {
    constructor(symbol, price) {
        super();
        this._symbol = symbol;
        this._price = price;
    }
}