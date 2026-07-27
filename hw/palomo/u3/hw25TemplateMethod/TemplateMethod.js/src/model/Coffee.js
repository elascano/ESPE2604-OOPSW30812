/**
 * @author Cristian Palomo, Error 404, @ESPE
 */
import { CaffeineBeverage } from "./CaffeineBeverage.js";
import { getUserInput } from "./consoleInput.js";

export class Coffee extends CaffeineBeverage {
    brew() {
        console.log("Dripping coffee through filter");
    }

    addCondiments() {
        console.log("Adding sugar and milk");
    }

    async wantsCondiments() {
        const answer = await getUserInput(
            "Would you like milk and sugar with your coffee (y/n)? "
        );
        return answer.toLowerCase().startsWith("y");
    }
}
