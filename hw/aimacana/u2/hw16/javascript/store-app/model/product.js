import { Tax } from "../../taxes-lib/tax.js";

export class Product {
    constructor(id, description, price, pvp = null) {
        this.id = id;
        this.description = description;
        this.price = price;
        if (pvp === null) {
            // Replicating Java constructor: pvp = Tax.computeTotal(price, 15F);
            this.pvp = Tax.computeTotal(price, 15.0);
        } else {
            this.pvp = pvp;
        }
    }

    toString() {
        return `Product\n{id=${this.id}, description='${this.description}', price=${this.price}, pvp=${this.pvp}}`;
    }
}
