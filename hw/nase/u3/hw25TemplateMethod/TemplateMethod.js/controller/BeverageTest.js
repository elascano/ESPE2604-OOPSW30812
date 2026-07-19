import { Tea } from '../model/Tea.js';
import { Coffee } from '../model/Coffee.js';
import { BeverageView } from '../view/BeverageView.js';

// Jennyfer Nase

function main() {
    const view = new BeverageView();
    
    const tea = new Tea();
    const coffee = new Coffee();
    
    view.printMessage("\nMaking tea ...");
    tea.prepareRecipe();
    
    view.printMessage("\nMaking coffee ...");
    coffee.prepareRecipe();
}

main();