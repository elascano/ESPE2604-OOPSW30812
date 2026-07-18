
package ec.edu.espe.TemplateMethod.model;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
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
