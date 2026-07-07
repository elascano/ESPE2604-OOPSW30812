export class FarmAnimal {
    constructor(id, breed, bornOn, weight, slaughterHouse = null, product = null, cuts = null) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
        this.slaughterHouse = slaughterHouse;
        this.product = product;
        this.cuts = cuts || [];
    }
    
    getAgeInMonths() {
        if (!this.bornOn) {
            throw new Error('bornOn is not set');
        }
        
        const today = new Date();
        if (this.bornOn > today) {
            throw new Error('bornOn can not be in the future');
        }
        
        const months = (today.getFullYear() - this.bornOn.getFullYear()) * 12 + 
                      (today.getMonth() - this.bornOn.getMonth());
        return months;
    }
    
    feed(food) {
        throw new Error('Method feed() must be implemented');
    }
    
    toString() {
        return `FarmAnimal(id=${this.id}, breed=${this.breed}, bornOn=${this.bornOn}, weight=${this.weight}, slaughterHouse=${this.slaughterHouse}, product=${this.product}, cuts=${this.cuts})`;
    }
}