const Chicken = require("../model/chicken");

const chicken = new Chicken(1, "Lucy", "White and brown", 1, true);

console.log("My chicken is --> " + chicken.toString());