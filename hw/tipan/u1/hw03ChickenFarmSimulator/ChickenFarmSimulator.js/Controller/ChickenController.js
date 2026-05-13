const prompt = require("prompt-sync")();

class ChickenController {

    constructor(chicken, view) {
        this.chicken = chicken;
        this.view = view;
    }

    start() {

        let option = 0;

        do {

            this.view.showMenu();

            option = parseInt(
                prompt("Select an option: ")
            );

            switch(option) {

                case 1:
                    this.view.showInformation(this.chicken);
                    break;

                case 2:
                    this.view.showMessage(
                        `\nAge: ${this.chicken.age} years`
                    );
                    break;

                case 3:
                    this.view.showMessage(
                        `\nWeight: ${this.chicken.weight.toFixed(2)} kg`
                    );
                    break;

                case 4:
                    this.view.showMessage(
                        `\nEggs per week: ${this.chicken.eggsPerWeek}`
                    );
                    break;

                case 5:
                    this.view.showMessage(
                        `\nFood type: ${this.chicken.foodType}`
                    );
                    break;

                case 6:
                    this.view.showMessage(
                        `\nColor: ${this.chicken.color}`
                    );
                    break;

                case 7:
                    this.view.showMessage("\nExiting...");
                    break;

                default:
                    this.view.showMessage(
                        "\nInvalid option"
                    );
            }

        } while(option !== 7);
    }
}

module.exports = ChickenController;