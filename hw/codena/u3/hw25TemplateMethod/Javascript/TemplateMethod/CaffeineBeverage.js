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
        console.log("Boiling Water");
    }

    pourInCup() {
        console.log("Pouring into cup");
    }

    wantsCondiments() {
        const answer = this.getUserInput();
        return answer.trim().toLowerCase() === "y";
    }

    brew() {
        throw new Error("brew() must be implemented.");
    }

    addCondiments() {
        throw new Error("addCondiments() must be implemented.");
    }

    getUserInput() {
        throw new Error("getUserInput() must be implemented.");
    }
}

module.exports = CaffeineBeverage;