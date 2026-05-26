import { Tax } from '../utils/Tax.js';

export class Product {
    id;
    description;
    price;
    pvp;

    constructor(id, description, price, pvp = null) {
        this.id = id;
        this.description = description;
        this.price = price;
        
        if (pvp === null) {
            // //TODO COMPUTE TOTAL PRICE
            this.pvp = Tax.computeTotal(price, 15);
        } else {
            this.pvp = pvp;
        }
    }

    getId() { return this.id; }
    getDescription() { return this.description; }
    getPrice() { return this.price; }
    getPvp() { return this.pvp; }

    toString() {
        return `Product{id=${this.id}, description=${this.description}, price=${this.price}, pvp=${this.pvp}}`;
    }
}


