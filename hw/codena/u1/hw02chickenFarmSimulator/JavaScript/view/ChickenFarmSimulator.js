import Chicken from "../model/Chicken.js";

function main() {
    const chicken = new Chicken(1, "Lucy", "White and brown", 1, true);
    console.log("my chicken --> " + chicken.toString());
}

main();