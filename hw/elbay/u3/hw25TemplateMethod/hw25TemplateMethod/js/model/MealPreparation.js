class MealPreparation {
    prepareMeal() {
        this.gatherIngredients();
        this.cook();
        this.plate();
        if (this.wantsGarnish()) {
            this.addGarnish();
        }
    }

    gatherIngredients() {
        console.log("Gathering ingredients");
    }

    cook() {
        throw new Error("cook() must be implemented");
    }

    plate() {
        console.log("Plating the dish");
    }

    addGarnish() {
        throw new Error("addGarnish() must be implemented");
    }

    wantsGarnish() {
        return true;
    }
}

module.exports = MealPreparation;
