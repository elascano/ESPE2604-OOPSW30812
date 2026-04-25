const Chicken = require('./JS_chicken/model/chicken'); // Importamos como 'Chicken'

const lucy = new Chicken(1, "Lucy", "White and Brown", 1, true); // Usamos 'Chicken'
console.log("My chicken -->", lucy.toString());