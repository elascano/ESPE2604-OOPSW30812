package ec.edu.espe.oopconceptszoo;

import ec.edu.espe.oopconceptszoo.view.CowView;
import javafx.application.Application;
import javafx.stage.Stage;

public class OOPConceptsZOO extends Application {

    @Override
    public void start(Stage primaryStage) {
        ec.edu.espe.oopconceptszoo.view.MainMenuView mainMenuView = new ec.edu.espe.oopconceptszoo.view.MainMenuView();
        mainMenuView.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
