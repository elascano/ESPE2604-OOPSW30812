package ec.edu.espe.oopconceptszoo.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {

    public void show(Stage primaryStage) {
        primaryStage.setTitle("OOP Concepts ZOO - Main Menu");

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Welcome to OOP Concepts ZOO");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button cowButton = new Button("Manage Cows");
        Button pigButton = new Button("Manage Pigs");
        Button sheepButton = new Button("Manage Sheeps");
        Button chickenButton = new Button("Manage Chickens");

        double buttonWidth = 200;
        cowButton.setPrefWidth(buttonWidth);
        pigButton.setPrefWidth(buttonWidth);
        sheepButton.setPrefWidth(buttonWidth);
        chickenButton.setPrefWidth(buttonWidth);

        Scene mainMenuScene = new Scene(layout, 400, 300);

        cowButton.setOnAction(e -> {
            CowView cowView = new CowView();
            cowView.show(primaryStage, mainMenuScene);
        });

        pigButton.setOnAction(e -> {
            PigView pigView = new PigView();
            pigView.show(primaryStage, mainMenuScene);
        });

        sheepButton.setOnAction(e -> {
            SheepView sheepView = new SheepView();
            sheepView.show(primaryStage, mainMenuScene);
        });

        chickenButton.setOnAction(e -> {
            ChickenView chickenView = new ChickenView();
            chickenView.show(primaryStage, mainMenuScene);
        });

        layout.getChildren().addAll(titleLabel, cowButton, pigButton, sheepButton, chickenButton);

        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }
}
