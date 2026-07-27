/**
 * @author Cristian Palomo, Error 404, @ESPE
 */
import { Stock } from "./Stock.js";

export class IBM extends Stock {
    constructor(symbol, price) {
        super();
        this.symbol = symbol;
        this.price = price;
    }
}
