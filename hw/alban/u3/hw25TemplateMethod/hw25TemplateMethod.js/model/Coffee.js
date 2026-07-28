import CaffeineBeverage from './CaffeineBeverage.js';

class Coffee extends CaffeineBeverage {
    brew() { console.log("Dripping coffee through filter"); }
    addCondiments() { console.log("Adding sugar and milk"); }
}
export default Coffee;