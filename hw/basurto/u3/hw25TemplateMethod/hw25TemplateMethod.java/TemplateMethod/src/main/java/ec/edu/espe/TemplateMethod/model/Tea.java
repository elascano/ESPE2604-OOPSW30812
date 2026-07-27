
package ec.edu.espe.TemplateMethod.model;

/**
 *
 * @author Esteban Basurto, Codebrakers,@ESPE
 */
public class Tea extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("Steep the tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding lemon");
    }
}
