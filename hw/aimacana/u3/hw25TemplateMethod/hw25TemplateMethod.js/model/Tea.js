import CaffeineBeverage from './CaffeineBeverage.js';

class Tea extends CaffeineBeverage {
    brew() { console.log("Steep the tea"); }
    addCondiments() { console.log("Adding lemon"); }
}
export default Tea;