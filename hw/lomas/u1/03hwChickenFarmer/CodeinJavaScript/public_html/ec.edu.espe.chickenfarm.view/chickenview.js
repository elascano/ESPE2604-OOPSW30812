import { ChickenController } from '../ec.edu.espe.chickenfarm.controller/chickencontroller.js';

const controller = new ChickenController();


const chicken = controller.createChicken(1, "Lucy", "White and Brown", 1, true);


console.log("My Chicken is ---->" + chicken.toString());

document.body.innerHTML = "<h1>Chicken Farm Simulator</h1>" + 
                          "<p>My Chicken is ---->" + chicken.toString() + "</p>";


