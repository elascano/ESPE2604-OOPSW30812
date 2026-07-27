class CaffeineBeverage {
    async prepareRecipe() {
        this.boilWater();
        this.brew();
        this.pourInCup();
        if (await this.wantsCondiments()) {
            this.addCondiments();
        }
    }

    boilWater() {
        console.log("Boiling water");
    }

    brew() {
        throw new Error("Method 'brew()' must be implemented.");
    }

    pourInCup() {
        console.log("Pouring into cup");
    }

    addCondiments() {
        throw new Error("Method 'addCondiments()' must be implemented.");
    }

    async wantsCondiments() {
        return true;
    }
}

module.exports = CaffeineBeverage;