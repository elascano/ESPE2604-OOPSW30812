package ec.edu.espe.chickenfarm.view;
import ec.edu.espe.chickenfarm.controller.ChickenController;
import ec.edu.espe.chickenfarm.model.Chicken;

public class ChickenView {
    public static void main(String[] args) {
        ChickenController controller = new ChickenController();
        Chicken chicken = controller.createChicken(1, "Lucy", "White and Brown", 1, true);
        
        System.out.println("My Chicken is ----> " + chicken.toString());
    }
}
