/**
 * @author Cristian Palomo, Error 404, @ESPE
 */
import { Coffee } from "../model/Coffee.js";
import { Tea } from "../model/Tea.js";
import { BeverageView } from "../view/BeverageView.js";

async function main() {
    const view = new BeverageView();

    const tea = new Tea();
    const coffee = new Coffee();

    view.printMessage("\nMaking tea ...");
    await tea.prepareRecipe();

    view.printMessage("\nMaking coffee ...");
    await coffee.prepareRecipe();
}

main();
