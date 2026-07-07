import { FarmAnimal } from './farm-animal.js';
import { IMeatAnimal } from '../controller/i-meat-animal.js';

export class Pig extends FarmAnimal {
    constructor(idealWeight, reachedIdealWeight, weight, breed, bornOn, id, slaughterHouse = null, product = null, cuts = null) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cuts);
        this.idealWeight = idealWeight;
        this.reachedIdealWeight = reachedIdealWeight;
    }
    
    feed(food) {
        console.log(`Feeding THE PIG with food --> ${food} in a bowl and water`);
        console.log(`Feeding the PIG with ${food.description}`);
        const newWeight = this.weight + 2.5;
        this.weight = newWeight;
        
        if (newWeight >= this.idealWeight) {
            this.reachedIdealWeight = true;
            console.log(`Pig ${this.id} has reached ideal weight: ${newWeight.toFixed(2)} kg`);
        } else {
            console.log(`Current weight: ${newWeight.toFixed(2)} kg (Ideal: ${this.idealWeight.toFixed(2)} kg)`);
        }
    }
    
    cut() {
        return [];
    }
    
    isReadyForSlaughter() {
        return this.reachedIdealWeight;
    }
    
    sendToSlaughterHouse(slaughterHouse) {
        if (this.isReadyForSlaughter()) {
            this.slaughterHouse = slaughterHouse;
            console.log(`PIG ${this.id} SENT TO SLAUGHTERHOUSE`);
            console.log(`SlaughterHouse: ${slaughterHouse.name}`);
            console.log(`Address: ${slaughterHouse.address}`);
            console.log(`Weight: ${this.weight.toFixed(2)} kg`);
            this._showPorkCuts();
        } else {
            console.log(`Pig ${this.id} is NOT ready for slaughter yet`);
            console.log(`Current weight: ${this.weight.toFixed(2)} kg`);
            console.log(`Ideal weight: ${this.idealWeight.toFixed(2)} kg`);
        }
    }
    
    _showPorkCuts() {
        console.log(`\nCUTS PERFORMED ON PIG ${this.id}:`);
        console.log("Jamón (Piernas traseras)");
        console.log("Paleta (Pierna delantera)");
        console.log("Costillar");
        console.log("Lomo de cerdo");
        console.log("All cuts have been completed successfully");
    }
    
    getIdealWeight() {
        return this.idealWeight;
    }
    
    setIdealWeight(idealWeight) {
        this.idealWeight = idealWeight;
    }
    
    isReachedIdealWeight() {
        return this.reachedIdealWeight;
    }
    
    setReachedIdealWeight(reachedIdealWeight) {
        this.reachedIdealWeight = reachedIdealWeight;
    }
}