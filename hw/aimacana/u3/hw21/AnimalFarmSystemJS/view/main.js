const Food = require("../model/Food");
const Product = require("../model/Product");
const SlaughterHouse = require("../model/SlaughterHouse");
const Pig = require("../model/Pig");
const Cow = require("../model/Cow");


const food = new Food(1, "Corn");

const slaughterHouse = new SlaughterHouse(
    1,
    "ESPE Slaughter House",
    "Sangolqui",
    "0999999999"
);


const pork = new Product(
    1,
    "Pork",
    "kg",
    50
);


const milk = new Product(
    2,
    "Milk",
    "liters",
    20
);


const cuts = [];


const pig = new Pig(
    100,
    1,
    "Yorkshire",
    new Date(2025, 0, 10),
    105,
    slaughterHouse,
    pork,
    cuts
);


const cow = new Cow(
    20,
    95,
    2,
    "Holstein",
    new Date(2024, 7, 20),
    450,
    slaughterHouse,
    milk,
    cuts
);


console.log("========== PIG ==========");
pig.feed(food);
console.log("Ready for slaughter?", pig.isReadyForSlaughter());


console.log();


console.log("========== COW ==========");
cow.feed(food);
console.log(cow.produce().toString());
cow.measureQuantity("liters", 20);