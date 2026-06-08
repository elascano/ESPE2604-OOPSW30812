/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
export class Tax {
    static computeIva(amount, taxPercentage) {
        return amount * (taxPercentage / 100.0);
    }

    static computeTotal(amount, taxPercentage) {
        return amount + Tax.computeIva(amount, taxPercentage);
    }
}

