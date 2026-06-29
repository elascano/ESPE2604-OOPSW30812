package ec.edu.espe.oopconceptszoo.view;

import ec.edu.espe.oopconceptszoo.controller.PigController;
import ec.edu.espe.oopconceptszoo.model.Pig;
import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PigView {
    private PigController pigController;
    private TableView<Pig> table;

    public PigView() {
        this.pigController = new PigController();
    }

    public void show(Stage primaryStage, Scene mainMenuScene) {
        primaryStage.setTitle("Zoo - Pig Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        TextField idInput = new TextField();
        TextField breedInput = new TextField();
        DatePicker bornOnInput = new DatePicker();
        TextField weightInput = new TextField();

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idInput, 1, 0);
        grid.add(new Label("Breed:"), 0, 1);
        grid.add(breedInput, 1, 1);
        grid.add(new Label("Born On:"), 0, 2);
        grid.add(bornOnInput, 1, 2);
        grid.add(new Label("Weight:"), 0, 3);
        grid.add(weightInput, 1, 3);

        Button addButton = new Button("Add Pig");
        grid.add(addButton, 1, 4);

        Button backButton = new Button("Back to Main Menu");
        grid.add(backButton, 1, 5);

        table = new TableView<>();
        TableColumn<Pig, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Pig, String> breedColumn = new TableColumn<>("Breed");
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));

        TableColumn<Pig, LocalDate> bornOnColumn = new TableColumn<>("Born On");
        bornOnColumn.setCellValueFactory(new PropertyValueFactory<>("bornOn"));

        TableColumn<Pig, Float> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        table.getColumns().addAll(idColumn, breedColumn, bornOnColumn, weightColumn);
        
        refreshTable();

        addButton.setOnAction(e -> {
            try {
                Pig pig = new Pig(
                        Integer.parseInt(idInput.getText()),
                        breedInput.getText(),
                        bornOnInput.getValue(),
                        Float.parseFloat(weightInput.getText())
                );
                pigController.addPig(pig);
                refreshTable();
            } catch (Exception ex) {
                System.out.println("Error parsing input: " + ex.getMessage());
            }
        });

        backButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(grid, table);

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
    }

    private void refreshTable() {
        table.getItems().clear();
        table.getItems().addAll(pigController.getAllPigs());
    }
}
