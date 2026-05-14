const fs = require("fs");

const Chicken = require("./model/Chicken");
const ChickenView = require("./view/ChickenView");
const ChickenController = require("./controller/ChickenController");


const chickenData = JSON.parse(
    fs.readFileSync("./model/chicken.json")
);


const lucy = new Chicken(
    chickenData.name,
    chickenData.age,
    chickenData.weight,
    chickenData.eggsPerWeek,
    chickenData.foodType,
    chickenData.color
);


const view = new ChickenView();

const controller = new ChickenController(
    lucy,
    view
);

controller.start();