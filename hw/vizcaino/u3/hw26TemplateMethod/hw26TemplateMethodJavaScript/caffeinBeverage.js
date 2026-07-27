class CaffeinBeverage {
    constructor() {
        if (this.constructor === CaffeinBeverage) {
            throw new Error("Cannot instantiate abstract class CaffeinBeverage");
        }
    }

    async prepareRecipe() {
        this.boilWater();
        this.brew();
        this.pourInCup();
        if (await this.wantsCondiments()) {
            this.addCondiments();
        }
    }

    brew() {
        throw new Error("Method 'brew()' must be implemented.");
    }

    addCondiments() {
        throw new Error("Method 'addCondiments()' must be implemented.");
    }

    boilWater() {
        console.log("Boiling water");
    }

    pourInCup() {
        console.log("Pouring into cup");
    }

    async wantsCondiments() {
        return true;
    }
}

module.exports = CaffeinBeverage;