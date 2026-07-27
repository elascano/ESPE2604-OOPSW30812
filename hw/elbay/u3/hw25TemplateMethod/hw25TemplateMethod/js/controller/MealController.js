const PastaDish = require("../model/PastaDish");
const SaladDish = require("../model/SaladDish");

class MealController {
    constructor(view) {
        this.view = view;
    }

    preparePasta() {
        this.view.showMessage("\nPreparing pasta ...");
        const pasta = new PastaDish();
        pasta.wantsGarnish = () => {
            const answer = this.view.getUserInput("Would you like parmesan on your pasta (y/n)?");
            return answer.toLowerCase().startsWith("y");
        };
        pasta.prepareMeal();
    }

    prepareSalad() {
        this.view.showMessage("\nPreparing salad ...");
        const salad = new SaladDish();
        salad.wantsGarnish = () => {
            const answer = this.view.getUserInput("Would you like croutons on your salad (y/n)?");
            return answer.toLowerCase().startsWith("y");
        };
        salad.prepareMeal();
    }
}

module.exports = MealController;
