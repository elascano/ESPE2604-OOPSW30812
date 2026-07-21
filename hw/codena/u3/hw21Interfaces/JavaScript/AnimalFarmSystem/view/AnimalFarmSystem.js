import Pig from "../model/Pig.js";
import Cow from "../model/Cow.js";
import Food from "../model/Food.js";
import Product from "../model/Product.js";
import Cut from "../model/Cut.js";
import SlaughterHouse from "../model/SlaughterHouse.js";

console.log("\n------PIG-----\n");

const date = new Date(2010, 10, 6); 

const slaughterHouse = new SlaughterHouse(
    1,
    null,
    "Av.omg 67",
    "0991231234"
);

const product = new Product(0, "", "", 0);

const cuts = [];

const pig = new Pig(
    120,
    1,
    "Tocinito",
    date,
    150,
    slaughterHouse,
    product,
    cuts
);

pig.cut();

console.log(pig.slaughterHouse);

console.log("\n--Sending to slaughterHouse--");

slaughterHouse.name = "Matadero Don PEPE";

console.log(pig.slaughterHouse);

pig.sendToSlaughterHouse(slaughterHouse);

pig.cut();

console.log("\n--Feed--");

const pigFood = new Food(1, "Mixed Feed");

pig.feed(pigFood);

console.log("\n\n------COW-----\n");

const cow = new Cow(
    false,
    0,
    0,
    "Holstein",
    date,
    0,
    null,
    null,
    []
);

cow.sendToSlaughterHouse(slaughterHouse);

cow.cut();

console.log("\n--Feed--");

const cowFood = new Food(2, "Grass");

cow.feed(cowFood);