import Tea from '../model/Tea.js';
import Coffee from '../model/Coffee.js';

class BeverageController {
    constructor(view) {
        this.view = view;
    }

    async prepareTea() {
        this.view.showMessage("\nMaking tea ...");
        let tea = new Tea();
        
        
        tea.wantsCondiments = async () => {
            let answer = await this.view.getUserInput("Would you like lemon with your tea (y/n)?");
            return answer.toLowerCase().startsWith("y");
        };
        
        
        tea.boilWater();
        tea.brew();
        tea.pourInCup();
        if (await tea.wantsCondiments()) {
            tea.addCondiments();
        }
    }

    async prepareCoffee() {
        this.view.showMessage("\nMaking coffee ...");
        let coffee = new Coffee();
        
        
        coffee.wantsCondiments = async () => {
            let answer = await this.view.getUserInput("Would you like milk and sugar with your coffee (y/n)?");
            return answer.toLowerCase().startsWith("y");
        };
        
        
        coffee.boilWater();
        coffee.brew();
        coffee.pourInCup();
        if (await coffee.wantsCondiments()) {
            coffee.addCondiments();
        }
    }
}
export default BeverageController;