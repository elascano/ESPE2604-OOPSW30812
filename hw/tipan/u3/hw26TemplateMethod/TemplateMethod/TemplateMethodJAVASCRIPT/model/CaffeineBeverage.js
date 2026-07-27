class CaffeineBeverage {

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
        throw new Error("The brew() method must be implemented");
    }

    pourInCup() {
        console.log("Pouring into cup");
    }

    addCondiments() {
        throw new Error("The addCondiments() method must be implemented");
    }

    wantsCondiments() {
        return true;
    }
}

module.exports = CaffeineBeverage;