
package ec.edu.espe.templatemethod.controller;
import ec.edu.espe.templatemethod.model.Tea;
import ec.edu.espe.templatemethod.model.Coffee;
import ec.edu.espe.templatemethod.model.Chocolate;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class BeverageController {
    public void prepareAllBeverages() {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        Chocolate chocolate = new Chocolate();

        System.out.println("\nMaking tea ...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee ...");
        coffee.prepareRecipe();

        System.out.println("\nMaking chocolate ...");
        chocolate.prepareRecipe();
    }
}