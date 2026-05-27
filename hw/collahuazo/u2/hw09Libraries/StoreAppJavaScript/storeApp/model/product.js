/**
 * @author: Collahuazo Brandon, CodeBros, @ESPE
 */

import { Tax } from '../../TaxLib/utils/tax.js';

export class Product {
    constructor(id, descripcion, price, pvp = null) {
        this.id = id;
        this.descripcion = descripcion;
        this.price = price;
        
    
        if (pvp === null) {
            this.pvp = Tax.computeTotal(price, 15);
        } else {
            this.pvp = pvp;
        }
    }


    toString() {
        return `Product\n{id=${this.id} descripcion=${this.descripcion} price=${this.price} pvp=${this.pvp}}`;
    }
}