/* 
 * "author": "Joel Sanchez, The Softwarriors, @ESPE"
 */
import Chicken from "../model/Chicken.js";

function main() {
    let chicken = new Chicken(1, "Lucy", "White and brown", 1, true);
    console.log("My chicken --- " + chicken.toString());
}

main();

