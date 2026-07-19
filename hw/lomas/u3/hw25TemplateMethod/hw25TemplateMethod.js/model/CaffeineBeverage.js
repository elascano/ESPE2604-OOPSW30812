class CaffeineBeverage {
    prepareRecipe() { // Template method
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

    brew() { throw new Error("Must implement brew()"); }

    pourInCup() {
        console.log("Pouring into cup");
    }

    addCondiments() { throw new Error("Must implement addCondiments()"); }

    wantsCondiments() { return true; } // Hook operation
}
export default CaffeineBeverage;