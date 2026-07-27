const MealView = require("./view/MealView");
const MealController = require("./controller/MealController");

const view = new MealView();
const controller = new MealController(view);

controller.preparePasta();
controller.prepareSalad();
