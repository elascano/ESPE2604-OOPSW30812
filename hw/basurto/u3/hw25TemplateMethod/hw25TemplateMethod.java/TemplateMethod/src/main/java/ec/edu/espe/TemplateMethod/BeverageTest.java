package ec.edu.espe.TemplateMethod;
import ec.edu.espe.TemplateMethod.controller.BeverageController;
import ec.edu.espe.TemplateMethod.view.BeverageView;

public class BeverageTest {
    public static void main(String[] args) {
        BeverageView view = new BeverageView();
        BeverageController controller = new BeverageController(view);

        controller.prepareTea();
        controller.prepareCoffee();
    }
}