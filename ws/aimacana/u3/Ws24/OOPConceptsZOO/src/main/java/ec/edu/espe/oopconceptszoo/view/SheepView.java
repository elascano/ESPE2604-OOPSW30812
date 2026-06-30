package ec.edu.espe.oopconceptszoo.view;

import ec.edu.espe.oopconceptszoo.controller.SheepController;
import ec.edu.espe.oopconceptszoo.model.Sheep;
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

public class SheepView {
    private SheepController sheepController;
    private TableView<Sheep> table;

    public SheepView() {
        this.sheepController = new SheepController();
    }

    public void show(Stage primaryStage, Scene mainMenuScene) {
        primaryStage.setTitle("Zoo - Sheep Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        TextField idInput = new TextField();
        TextField breedInput = new TextField();
        DatePicker bornOnInput = new DatePicker();
        TextField weightInput = new TextField();
        DatePicker lastSheeredInput = new DatePicker();

        grid.add(new Label("ID:"), 0, 0);
        grid.add(idInput, 1, 0);
        grid.add(new Label("Breed:"), 0, 1);
        grid.add(breedInput, 1, 1);
        grid.add(new Label("Born On:"), 0, 2);
        grid.add(bornOnInput, 1, 2);
        grid.add(new Label("Weight:"), 0, 3);
        grid.add(weightInput, 1, 3);
        grid.add(new Label("Last Sheered:"), 0, 4);
        grid.add(lastSheeredInput, 1, 4);

        Button addButton = new Button("Add Sheep");
        grid.add(addButton, 1, 5);

        Button backButton = new Button("Back to Main Menu");
        grid.add(backButton, 1, 6);

        table = new TableView<>();
        TableColumn<Sheep, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Sheep, String> breedColumn = new TableColumn<>("Breed");
        breedColumn.setCellValueFactory(new PropertyValueFactory<>("breed"));

        TableColumn<Sheep, LocalDate> bornOnColumn = new TableColumn<>("Born On");
        bornOnColumn.setCellValueFactory(new PropertyValueFactory<>("bornOn"));

        TableColumn<Sheep, Float> weightColumn = new TableColumn<>("Weight");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<Sheep, LocalDate> lastSheeredColumn = new TableColumn<>("Last Sheered");
        lastSheeredColumn.setCellValueFactory(new PropertyValueFactory<>("lastSheered"));

        table.getColumns().addAll(idColumn, breedColumn, bornOnColumn, weightColumn, lastSheeredColumn);
        
        refreshTable();

        addButton.setOnAction(e -> {
            try {
                Sheep sheep = new Sheep(
                        Integer.parseInt(idInput.getText()),
                        breedInput.getText(),
                        bornOnInput.getValue(),
                        Float.parseFloat(weightInput.getText()),
                        lastSheeredInput.getValue()
                );
                sheepController.addSheep(sheep);
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
        table.getItems().addAll(sheepController.getAllSheeps());
    }
}
