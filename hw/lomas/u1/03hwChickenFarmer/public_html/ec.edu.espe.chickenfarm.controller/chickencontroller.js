import { Chicken } from '../ec.edu.espe.chickenfarmer.model/chickenmodel.js';

export class ChickenController {
    constructor() {
        this.chickens = [];
    }

    createChicken(id, name, color, age, isMolting) {
        const newChicken = new Chicken(id, name, color, age, isMolting);
        this.chickens.push(newChicken);
        return newChicken;
    }
}


