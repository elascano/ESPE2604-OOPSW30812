package ec.edu.espe.oopconceptszoo.view;

import ec.edu.espe.oopconceptszoo.controller.ChickenController;
import ec.edu.espe.oopconceptszoo.model.Chicken;
import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChickenView {
    private ChickenController chickenController;
    private TableView<Chicken> table;

    public ChickenView() {
        this.chickenController = new ChickenController();
    }

    public void show(Stage primaryStage, Scene mainMenuScene) {
        primaryStage.setTitle("Zoo - Chicken Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        TextField idInput = new TextField();
        TextField breedInput = new TextField();
        DatePicker bornOnInput = new DatePicker();
        TextField weightInput = new TextField();
        CheckBox isMoltingInput = new CheckBox("Is Molting?");

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idInput, 1, 0);
        grid.add(new Label("Breed:"), 0, 1);
        grid.add(breedInput, 1, 1);
        grid.add(new Label("Born On:"), 0, 2);
        grid.add(bornOnInput, 1, 2);
        grid.add(new Label("Weight:"), 0, 3);
        grid.add(weightInput, 1, 3);
        grid.add(isMoltingInput, 1, 4);

        Button addButton = new Button("Add Chicken");
        grid.add(addButton, 1, 5);

        Button backButton = new Button("Back to Main Menu");
        grid.add(backButton, 1, 6);

        table = new TableView<>();
        TableColumn<Chicken, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Chicken, String> breedColumn = new TableColumn<>("Breed");
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));

        TableColumn<Chicken, LocalDate> bornOnColumn = new TableColumn<>("Born On");
        bornOnColumn.setCellValueFactory(new PropertyValueFactory<>("bornOn"));

        TableColumn<Chicken, Float> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<Chicken, Boolean> moltingColumn = new TableColumn<>("Molting?");
        moltingColumn.setCellValueFactory(new PropertyValueFactory<>("isMolting"));

        table.getColumns().addAll(idColumn, breedColumn, bornOnColumn, weightColumn, moltingColumn);
        
        refreshTable();

        addButton.setOnAction(e -> {
            try {
                Chicken chicken = new Chicken(
                        Integer.parseInt(idInput.getText()),
                        breedInput.getText(),
                        bornOnInput.getValue(),
                        Float.parseFloat(weightInput.getText()),
                        isMoltingInput.isSelected()
                );
                chickenController.addChicken(chicken);
                refreshTable();
            } catch (Exception ex) {
                System.out.println("Error parsing input: " + ex.getMessage());
            }
        });

        backButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(grid, table);

        Scene scene = new Scene(layout, 550, 500);
        primaryStage.setScene(scene);
    }

    private void refreshTable() {
        table.getItems().clear();
        table.getItems().addAll(chickenController.getAllChickens());
    }
}
