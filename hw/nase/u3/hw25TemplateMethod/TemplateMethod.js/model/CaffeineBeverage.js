// Jennyfer Nase

export class CaffeineBeverage {
    constructor() {
        if (this.constructor === CaffeineBeverage) {
            throw new Error("No puedes instanciar una clase abstracta directamente.");
        }
    }

    prepareRecipe() {
        this.boilWater();
        this.brew();
        this.pourInCup();
        if (this.wantsCondiments()) {
            this.addCondiments();
        }
    }

    boilWater() {
        console.log("Boiling water");
    }

    brew() {
        throw new Error("The 'brew()' method must be implemented by the subclass.");
    }

    addCondiments() {
        throw new Error("The 'addCondiments()' method must be implemented by the subclass.");
    }

    pourInCup() {
        console.log("Pouring into cup");
    }

    wantsCondiments() {
        return true;
    }
}