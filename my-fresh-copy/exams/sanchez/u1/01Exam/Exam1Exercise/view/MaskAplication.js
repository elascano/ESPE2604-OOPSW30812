/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */
import pkg from '../model/Mask.js';

function main() {
    let cant, price, color;
    cant= 3;
    price= 1,30;
    color="blue";
    
    let mask = new Mask(cant, price, color);
    console.log(`Color Mask ${mask.color()}`);
    console.log(`Total price the Mask ${mask.totalPrice()}`);
    
    
 }

