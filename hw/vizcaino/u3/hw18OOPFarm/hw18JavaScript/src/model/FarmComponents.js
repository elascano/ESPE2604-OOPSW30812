export class FarmAnimal {
    constructor(id, breed, bornOn, weight) {
        this.id = parseInt(id);
        this.breed = breed;
        this.bornOn = new Date(bornOn);
        this.weight = parseFloat(weight);
        this.actionsLog = []; 
    }

    getAgeInMonths() {
        const today = new Date();
        const diffTime = Math.abs(today - this.bornOn);
        const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
        return Math.floor(diffDays / 30.44); 
    }

    feed() {
        this.weight = parseFloat((this.weight * 1.02).toFixed(2)); 
        this.actionsLog.push(`[${new Date().toLocaleString()}] Alimentado: Peso aumentó a ${this.weight}kg`);
    }
}

export class Cow extends FarmAnimal {
    constructor(id, breed, bornOn, weight, isProducingMilk, dailyMilkYield) {
        super(id, breed, bornOn, weight);
        this.isProducingMilk = isProducingMilk === true || isProducingMilk === 'true';
        this.dailyMilkYield = parseFloat(dailyMilkYield || 0);
    }

    milk(liters) {
        const addedLiters = parseFloat(liters || 0);
        this.dailyMilkYield = parseFloat((this.dailyMilkYield + addedLiters).toFixed(2));
        this.actionsLog.push(`[${new Date().toLocaleString()}] Ordeño ejecutado: se extrajeron ${addedLiters} litros. Producción acumulada: ${this.dailyMilkYield}L`);
    }
}

export class Chicken extends FarmAnimal {
    constructor(id, breed, bornOn, weight, isMolting, numberOfEggsPerWeek, eggColor) {
        super(id, breed, bornOn, weight);
        this.isMolting = isMolting === true || isMolting === 'true';
        this.numberOfEggsPerWeek = parseInt(numberOfEggsPerWeek || 0);
        this.eggColor = eggColor;
    }

    layAnEgg() {
        this.numberOfEggsPerWeek += 1;
        this.actionsLog.push(`[${new Date().toLocaleString()}] Acción layAnEgg: La gallina puso un huevo. Total semanal: ${this.numberOfEggsPerWeek}`);
    }
}

export class Sheep extends FarmAnimal {
    constructor(id, breed, bornOn, weight, lastSheering, woolQuality) {
        super(id, breed, bornOn, weight);
        this.lastSheering = lastSheering ? new Date(lastSheering).toLocaleDateString() : new Date().toLocaleDateString();
        this.woolQuality = woolQuality;
    }

    shear() {
        this.lastSheering = new Date().toLocaleDateString();
        this.actionsLog.push(`[${new Date().toLocaleString()}] Acción shear: Oveja esquilada con éxito. Calidad registrada: ${this.woolQuality}`);
    }
}

export class Pig extends FarmAnimal {
    constructor(id, breed, bornOn, weight, idealWeight, penNumber) {
        super(id, breed, bornOn, weight);
        this.idealWeight = parseFloat(idealWeight);
        this.penNumber = parseInt(penNumber);
        this.slaughterStatus = "Pending";
    }

    cut() {
        let result = "";
        if (this.weight >= this.idealWeight) {
            result = "Procesamiento Completo: Rendimiento del 70% en cortes 'Premium'.";
        } else {
            result = "Procesamiento Completo: Rendimiento reducido del 55% en cortes comerciales.";
        }
        this.slaughterStatus = "Processed";
        this.actionsLog.push(`[${new Date().toLocaleString()}] Acción cut: ${result}`);
        return result;
    }
}