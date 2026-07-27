package controller;

import model.*;
import view.MealView;

public class MealController {
    private MealView view;

    public MealController(MealView view) {
        this.view = view;
    }

    public void preparePasta() {
        view.showMessage("\nPreparing pasta ...");
        MealPreparation pasta = new PastaDish() {
            @Override
            public boolean wantsGarnish() {
                String answer = view.getUserInput("Would you like parmesan on your pasta (y/n)?");
                return answer.toLowerCase().startsWith("y");
            }
        };
        pasta.prepareMeal();
    }

    public void prepareSalad() {
        view.showMessage("\nPreparing salad ...");
        MealPreparation salad = new SaladDish() {
            @Override
            public boolean wantsGarnish() {
                String answer = view.getUserInput("Would you like croutons on your salad (y/n)?");
                return answer.toLowerCase().startsWith("y");
            }
        };
        salad.prepareMeal();
    }
}
