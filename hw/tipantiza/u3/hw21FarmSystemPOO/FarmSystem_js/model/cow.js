import { FarmAnimal } from './farm-animal.js';
import { IMeatAnimal } from '../controller/i-meat-animal.js';

export class Cow extends FarmAnimal {
    static MIN_MILK_PRODUCTION = 5.0;
    
    constructor(id, canProduceMilk, breed, bornOn, weight, slaughterHouse = null, product = null, cuts = null, milkProduction = 0.0) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.milkProduction = milkProduction;
        this.canProduceMilk = milkProduction >= Cow.MIN_MILK_PRODUCTION;
    }
    
    feed(food) {
        console.log(`Feeding the COW with ${food.description}`);
        if (this.canProduceMilk) {
            this.milkProduction -= 0.3;
            if (this.milkProduction < Cow.MIN_MILK_PRODUCTION) {
                this.canProduceMilk = false;
                console.log(`Cow ${this.id} can NO LONGER produce milk!`);
                console.log(`Current production: ${this.milkProduction.toFixed(2)} L/day`);
                console.log(`Minimum required: ${Cow.MIN_MILK_PRODUCTION} L/day`);
            } else {
                console.log(`Milk production: ${this.milkProduction.toFixed(2)} L/day`);
            }
        }
    }
    
    cut() {
        throw new Error('Not supported yet.');
    }
    
    sendToSlaughterHouse(slaughterHouse) {
        if (this.isReadyForSlaughter()) {
            this.slaughterHouse = slaughterHouse;
            console.log(`COW ${this.id} SENT TO SLAUGHTERHOUSE`);
            console.log(`SlaughterHouse: ${slaughterHouse.name}`);
            console.log(`Address: ${slaughterHouse.address}`);
            console.log("Reason: No longer produces milk");
            console.log(`Final milk production: ${this.milkProduction.toFixed(2)} L/day`);
            console.log(`Weight: ${this.weight} kg`);
            this._showBeefCuts();
        } else {
            console.log(`Cow ${this.id} is NOT ready for slaughter yet`);
            console.log(`Milk production: ${this.milkProduction.toFixed(2)} L/day`);
            console.log(`Can produce milk: ${this.canProduceMilk ? 'YES' : 'NO'}`);
        }
    }
    
    _showBeefCuts() {
        console.log(`\nCUTS PERFORMED ON COW ${this.id}:`);
        console.log("Lomo Fino");
        console.log("Picaña");
        console.log("Costilla de res");
        console.log("Pulpa negra (bistecs)");
        console.log("Pulpa blanca (bistecs)");
        console.log("All cuts have been completed successfully");
    }
    
    isReadyForSlaughter() {
        return !this.canProduceMilk;
    }
    
    getMilkProduction() {
        return this.milkProduction;
    }
    
    setMilkProduction(milkProduction) {
        this.milkProduction = milkProduction;
        this.canProduceMilk = milkProduction >= Cow.MIN_MILK_PRODUCTION;
    }
    
    isCanProduceMilk() {
        return this.canProduceMilk;
    }
    
    setCanProduceMilk(canProduceMilk) {
        this.canProduceMilk = canProduceMilk;
    }
    
    static getMinMilkProduction() {
        return Cow.MIN_MILK_PRODUCTION;
    }
}