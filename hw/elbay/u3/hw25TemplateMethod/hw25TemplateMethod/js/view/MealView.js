const readline = require("readline-sync");

class MealView {
    showMessage(message) {
        console.log(message);
    }

    getUserInput(prompt) {
        return readline.question(prompt + "\n");
    }
}

module.exports = MealView;
