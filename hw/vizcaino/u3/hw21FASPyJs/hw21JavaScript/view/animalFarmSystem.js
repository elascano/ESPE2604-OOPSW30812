import { Cow } from "../model/cow.js";
import { Pig } from "../model/pig.js";
import { Product } from "../model/product.js";
import { SlaughterHouse } from "../model/slaughterHouse.js";

const slaughterHouse = new SlaughterHouse(
    1,
    "Central Slaughter House",
    "Quito",
    "0999999999"
);

const product = new Product(
    1,
    "Milk",
    "Liters",
    0
);

const cuts = [];

const pig = new Pig(
    120,
    35,
    1,
    "Yorkshire",
    new Date(2024, 0, 1),
    130,
    slaughterHouse,
    null,
    cuts
);

const cow = new Cow(
    true,
    62,
    2,
    "Holstein",
    new Date(2022, 5, 1),
    550,
    slaughterHouse,
    product,
    cuts
);

console.log("Hello World!");

console.log(pig.toString());
console.log(cow.toString());

console.log(pig.cut());

cow.measureQuantity(
    "Liters",
    15.5
);

console.log(cow.produce());

console.log(cow.cut());