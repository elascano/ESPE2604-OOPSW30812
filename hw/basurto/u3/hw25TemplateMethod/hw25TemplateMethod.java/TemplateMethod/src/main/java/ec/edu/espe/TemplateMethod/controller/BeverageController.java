
package ec.edu.espe.TemplateMethod.controller;
import ec.edu.espe.TemplateMethod.model.*;
import ec.edu.espe.TemplateMethod.view.BeverageView;
/**
 *
 *
 * 
 * @author Esteban Basurto, Codebrakers,@ESPE
 */
public class BeverageController {
    private BeverageView view;

    public BeverageController(BeverageView view) {
        this.view = view;
    }

    public void prepareTea() {
        view.showMessage("\nMaking tea ...");
        CaffeineBeverage tea = new Tea() {
            @Override
            public boolean wantsCondiments() {
                String answer = view.getUserInput("Would you like lemon with your tea (y/n)?");
                return answer.toLowerCase().startsWith("y");
            }
        };
        tea.prepareRecipe();
    }

    public void prepareCoffee() {
        view.showMessage("\nMaking coffee ...");
        CaffeineBeverage coffee = new Coffee() {
            @Override
            public boolean wantsCondiments() {
                String answer = view.getUserInput("Would you like milk and sugar with your coffee (y/n)?");
                return answer.toLowerCase().startsWith("y");
            }
        };
        coffee.prepareRecipe();
    }
}
