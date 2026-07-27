import controller.MealController;
import view.MealView;

public class MealTest {
    public static void main(String[] args) {
        MealView view = new MealView();
        MealController controller = new MealController(view);

        controller.preparePasta();
        controller.prepareSalad();
    }
}
