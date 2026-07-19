
package ec.edu.espe.TemplateMethod.model;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
public class Coffee extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
