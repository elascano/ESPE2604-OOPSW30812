
package ec.edu.espe.templatemethod.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public abstract class CaffeineBeverage {
    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (wantsCondiments()) {
            addCondiments();
        }
    }

    void boilWater() {
        System.out.println("Boiling water");
    }

    public abstract void brew();

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    public abstract void addCondiments();

    boolean wantsCondiments() {
        return true;
    }
}
