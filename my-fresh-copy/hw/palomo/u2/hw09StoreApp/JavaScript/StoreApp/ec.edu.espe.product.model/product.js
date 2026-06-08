/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
import { Tax } from "../../taxes-lib/tax.js";

export class Product {
    constructor(id, description, price, pvp = null) {
        this.id = id;
        this.description = description;
        this.price = price;
        if (pvp === null) {
            this.pvp = Tax.computeTotal(price, 15.0);
        } else {
            this.pvp = pvp;
        }
    }

    toString() {
        return `Product\n{id=${this.id}, description='${this.description}', price=${this.price}, pvp=${this.pvp}}`;
    }
}
