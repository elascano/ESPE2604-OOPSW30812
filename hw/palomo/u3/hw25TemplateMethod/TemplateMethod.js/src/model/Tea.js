/**
 * @author Cristian Palomo, Error 404, @ESPE
 */
import { CaffeineBeverage } from "./CaffeineBeverage.js";
import { getUserInput } from "./consoleInput.js";

export class Tea extends CaffeineBeverage {
    brew() {
        console.log("Steep the tea");
    }

    addCondiments() {
        console.log("Adding lemon");
    }

    async wantsCondiments() {
        const answer = await getUserInput("Would you like lemon with your tea (y/n)? ");
        return answer.toLowerCase().startsWith("y");
    }
}
